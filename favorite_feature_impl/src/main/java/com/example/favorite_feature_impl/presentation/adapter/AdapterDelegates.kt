package com.example.favorite_feature_impl.presentation.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import com.example.favorite_feature_impl.R
import com.example.favorite_feature_impl.databinding.ItemFavoriteVacancyBinding
import com.example.favorite_feature_impl.presentation.model.VacancyUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


fun vacancyDelegate(listener: VacancyItemListener) =
    adapterDelegateViewBinding<VacancyUI, VacancyUI, ItemFavoriteVacancyBinding>({ layoutInflater,
                                                                                   root ->
        ItemFavoriteVacancyBinding.inflate(layoutInflater, root, false)
    }) {

        with(binding) {

            root.setOnClickListener {
                listener.onVacancyClickListener(item)
            }
            ivFavorite.setOnClickListener {
                listener.onFavoriteIconClick(item)
            }
        }
        bind { payload ->
            with(binding) {
                when {
                    payload.isEmpty() -> {
                        tvNowWatching.isVisible = item.lookingNumber > 0
                        val people: String =
                            context.resources.getQuantityString(
                                com.example.core_utils.R.plurals.plurals_vacancies,
                                item.lookingNumber,
                                item.lookingNumber
                            )
                        tvNowWatching.text = context.getString(com.example.core_utils.R.string.now_looking, people)
                        tvVacanyName.text = item.title
                        tvSalary.text = item.salary.full
                        tvCity.text = item.address.town
                        tvCompany.text = item.company
                        tvExperience.text = item.experience.previewText
                        tvPublicated.text = item.publishedDate

                        val drawable = if (item.isFavorite) {
                            com.example.core_utils.R.drawable.ic_favourite_fill
                        } else {
                            com.example.core_utils.R.drawable.ic_favourite
                        }
                        ivFavorite.setImageDrawable(
                            AppCompatResources.getDrawable(
                                context,
                                drawable
                            )
                        )
                    }
                }
            }
        }
    }