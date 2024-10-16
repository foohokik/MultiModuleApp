package com.example.full_vacancy_feature_impl.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.core_utils.extensions.assistedViewModel
import com.example.core_utils.presentation.BaseDialogBinding
import com.example.full_vacancy_feature_impl.R
import com.example.full_vacancy_feature_impl.databinding.FragmentFullVacancyBinding
import com.example.full_vacancy_feature_impl.di.FullVacancyFeatureComponentHolder
import com.example.full_vacancy_feature_impl.presentation.adapter.QuestionAdapter
import com.example.full_vacancy_feature_impl.presentation.model.VacancyUI
import kotlinx.coroutines.launch


class FullVacancyFragment :
    BaseDialogBinding<FragmentFullVacancyBinding>(FragmentFullVacancyBinding::inflate) {


    private val viewModel: FullVacancyViewModel by assistedViewModel {
        FullVacancyFeatureComponentHolder.getComponent().getDetailVacancyViewModelFactory()
            .create(it)
    }

    private lateinit var questionsAdapter: QuestionAdapter

    init {
        FullVacancyFeatureComponentHolder.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearchRecycleView()
        observe()
    }

    private fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.contentVacancyState.collect {
                        initView(it)
                    }
                }
            }
        }
    }

    private fun initSearchRecycleView() {
        with(binding.rvQuestions) {
            questionsAdapter = QuestionAdapter()
            adapter = questionsAdapter
        }
    }

    private fun initView(vacancy: VacancyUI) {
        with(binding) {
            tvTitle.text = vacancy.title
            tvSalary.text = vacancy.salary.full
            tvExperience.text =
                requireContext().getString(R.string.tv_experience, vacancy.experience.text)
            tvSchedules.text = vacancy.schedules
            val peopleAppliedText = requireContext().resources.getQuantityString(
                com.example.core_utils.R.plurals.plurals_vacancies,
                vacancy.appliedNumber,
                vacancy.appliedNumber
            )
            tvAppliedPeople.text =
                requireContext().getString(R.string.tv_applied_people, peopleAppliedText)
            val lookingNumberText = requireContext().resources.getQuantityString(
                com.example.core_utils.R.plurals.plurals_vacancies,
                vacancy.lookingNumber,
                vacancy.lookingNumber
            )
            tvLookingNumber.text =
                requireContext().getString(R.string.tv_looking_number, lookingNumberText)
            tvCompanyName.text = vacancy.company
            tvAddress.text =
                "${vacancy.address.town}, ${vacancy.address.street}, ${vacancy.address.house}"
            tvDescripton.text = vacancy.description
            tvResponsibilities.text = vacancy.responsibilities
            questionsAdapter.items = vacancy.questions
            val drawable = if (vacancy.isFavorite) {
                com.example.core_utils.R.drawable.ic_favourite_fill
            } else {
                com.example.core_utils.R.drawable.ic_favourite
            }
            ivFavorite.setImageDrawable(
                AppCompatResources.getDrawable(
                    requireContext(),
                    drawable
                )
            )

            ivFavorite.setOnClickListener {
                viewModel.onFavoriteIconClick()
            }

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnResponse.setOnClickListener {
                findNavController()
                    .navigate(
                        FullVacancyFragmentDirections.actionFullVacancyFragmentToResponseFragment(
                            vacancy.title
                        )
                    )
            }
        }
    }


}