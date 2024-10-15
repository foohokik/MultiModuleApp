package com.example.search_feature_impl.presentation.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import com.example.search_feature_impl.databinding.ItemButtonBinding
import com.example.search_feature_impl.databinding.ItemSearchHeaderBinding
import com.example.search_feature_impl.databinding.ItemSearchOfferRvBinding
import com.example.search_feature_impl.databinding.ItemSearchVacancyBinding
import com.example.search_feature_impl.presentation.model.OffersUI
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun offerRecycleDelegate() = adapterDelegateViewBinding<
        OffersUI.CommonList, OffersUI, ItemSearchOfferRvBinding>({ layoutInflater,
                                                                   root ->
    ItemSearchOfferRvBinding.inflate(layoutInflater, root, false)
}) {

    bind {
        with(binding) {
            val adapter = OfferAdapter()
            offerBlocksRecyclerView.adapter = adapter
            adapter.items = item.offers
        }
    }

}


fun vacancyDelegate(listener: VacancyItemListener) =
    adapterDelegateViewBinding<OffersUI.VacancyUI, OffersUI, ItemSearchVacancyBinding>({ layoutInflater,
                                                                                         root ->
        ItemSearchVacancyBinding.inflate(layoutInflater, root, false)
    }) {

        with(binding) {

            root.setOnClickListener {
                listener.onVacancyClickListener(item)
            }
            ivFavorite.setOnClickListener {
                listener.onFavoriteIconClick(item)
            }
        }
        bind {
            with(binding) {

                tvNowWatching.isVisible = item.lookingNumber > 0
                val people: String =
                    context.resources.getQuantityString(
                        com.example.core_utils.R.plurals.plurals_vacancies,
                        item.lookingNumber,
                        item.lookingNumber
                    )
                tvNowWatching.text =
                    context.getString(com.example.core_utils.R.string.now_looking, people)
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


fun headerDelegate() =
    adapterDelegateViewBinding<OffersUI.Header, OffersUI, ItemSearchHeaderBinding>(
        { layoutInflater,
          root ->
            ItemSearchHeaderBinding.inflate(layoutInflater, root, false)
        }) {

        with(binding) {
            bind {
                tvVacanciesForYou.text = item.header
            }
        }
    }

fun buttonDelegate(listener: ButtonItemListener) =
    adapterDelegateViewBinding<OffersUI.QuantityOfVacanciesButton, OffersUI, ItemButtonBinding>(
        { layoutInflater,
          root ->
            ItemButtonBinding.inflate(layoutInflater, root, false)
        }) {

        with(binding) {
            bind {
                btnAllVacancies.setOnClickListener {
                    listener.onClickButton()
                }
                val text =
                    context.resources.getQuantityString(
                        com.example.core_utils.R.plurals.plurals_button, item.qty, item.qty
                    )
                btnAllVacancies.text = "Еще $text"
            }
        }
    }

