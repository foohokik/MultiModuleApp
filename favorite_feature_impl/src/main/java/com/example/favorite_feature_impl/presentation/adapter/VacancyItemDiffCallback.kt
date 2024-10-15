package com.example.favorite_feature_impl.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.favorite_feature_impl.presentation.model.VacancyUI

class VacancyItemDiffCallback: DiffUtil.ItemCallback<VacancyUI>() {

    override fun areItemsTheSame(oldItem: VacancyUI, newItem: VacancyUI): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: VacancyUI, newItem: VacancyUI): Boolean =
        oldItem == newItem

}
