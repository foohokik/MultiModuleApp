package com.example.auth_feature_impl.presentation.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.auth_feature_impl.databinding.FragmentLoginBinding
import com.example.auth_feature_impl.di.AuthFeatureComponentHolder
import com.example.auth_feature_impl.presentation.SideEffects
import com.example.core_utils.extensions.hideKeyboard
import com.example.core_utils.extensions.lazyViewModel
import com.example.core_utils.extensions.showKeyBoard
import com.example.core_utils.presentation.BaseFragmentBinding
import kotlinx.coroutines.launch


class LoginFragment : BaseFragmentBinding<FragmentLoginBinding> (FragmentLoginBinding::inflate)
{

    private val viewModel: LoginViewModel by lazyViewModel {
        AuthFeatureComponentHolder.getComponent().getLoginViewModelFactory().create()
    }

    init {
        AuthFeatureComponentHolder.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textListener()
        closeEnteringSearch()
        observe()
        checkEmail()
    }

    private fun checkEmail() {
        binding.btnContinue.setOnClickListener{
            viewModel.checkEmailAndNavigate()
        }
    }

    private fun textListener() {
        binding.editText.doAfterTextChanged { text->
            text?.let {
                if (text.toString().isNotEmpty()) {
                    viewModel.listenEmail(text.toString().replace(" ", ""))
                }
            }
        }
    }

    private fun closeEnteringSearch() {
        binding.editEmail.setEndIconOnClickListener {
            with(binding.editText) {
                this.text?.clear()
                this.clearFocus()
                this.isCursorVisible = false
            }
            binding.editEmail.background = null
            binding.tvWrongEmailError.visibility = View.GONE
            activity?.hideKeyboard()
            viewModel.clearFlowAndOnChangeKeyBoardFlag()

        }
    }


    private fun renderQuery(text: String) {
        if (text != binding.editText.text.toString()) {
            binding.editText.setText(text)
        }
    }

    private fun renderKeyboard(isShow: Boolean) {
        if (isShow) {
            with(binding.editText) {
                requestFocus()
                context.showKeyBoard(this)
            }
        } else {
            activity?.hideKeyboard()
        }
    }

    private fun handleSideEffects(sideEffects: SideEffects) {
        when (sideEffects) {
            is SideEffects.ErrorEffect -> {
                with(binding) {
                    tvWrongEmailError.visibility = View.VISIBLE
                    tvWrongEmailError.text = sideEffects.err
                    editEmail.background = AppCompatResources.getDrawable(requireContext(), com.example.core_utils.R.drawable.background_edit_error)
                }
            }
            is SideEffects.ExceptionEffect -> {
                TODO()
            }
            is SideEffects.ClickEffectNavigation -> {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToPinFragment(sideEffects.email))
            }
        }
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.searchFlowState.collect { state ->
                        renderKeyboard(state.keyboardState)
                        renderQuery(state.email)
                    }
                }
                launch { viewModel.sideEffects.collect { handleSideEffects(it) } }
            }
        }
    }


}