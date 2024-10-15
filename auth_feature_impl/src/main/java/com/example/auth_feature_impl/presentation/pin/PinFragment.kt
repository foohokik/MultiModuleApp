package com.example.auth_feature_impl.presentation.pin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.auth_feature_impl.R
import com.example.auth_feature_impl.databinding.FragmentLoginBinding
import com.example.auth_feature_impl.databinding.FragmentPinBinding
import com.example.auth_feature_impl.di.AuthFeatureComponentHolder
import com.example.core_utils.extensions.lazyViewModel
import com.example.core_utils.presentation.BaseFragmentBinding
import kotlinx.coroutines.launch
import v.shihanova.core_utils.extensions.showKeyBoard

class PinFragment : BaseFragmentBinding<FragmentPinBinding>(FragmentPinBinding::inflate) {

    private val args by navArgs<PinFragmentArgs>()

    private val viewModel: PinViewModel by lazyViewModel {
        AuthFeatureComponentHolder.getComponent().getPinViewModelFactory().create()
    }

    init {
        AuthFeatureComponentHolder.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setEmail()
        initView()
        observe()
    }

    private fun setEmail() {
        val email = args.email
        binding.tvHeadderEmail.text = "${binding.tvHeadderEmail.text} ${email}"
    }

    private fun initView() {
        with(binding){
            requireContext().showKeyBoard(pin)
            binding.pin.doAfterTextChanged {
                viewModel.checkPin(it.toString())
            }
            btnToMain.setOnClickListener {
                findNavController().navigate("app://search".toUri())
            }
        }
    }

    private fun renderButton (isEnable:Boolean) {
        binding.btnToMain.isEnabled = isEnable
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.isButtonEnabled.collect{
                    renderButton(it) }
                }
            }
        }
    }

}