package com.example.search_feature_impl.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.search_feature_impl.presentation.model.OffersUI

internal class SearchAdapterDiffCallback : DiffUtil.ItemCallback<OffersUI>() {

    override fun areItemsTheSame(oldItem: OffersUI, newItem: OffersUI): Boolean =
        oldItem.javaClass == newItem.javaClass


    override fun areContentsTheSame(oldItem: OffersUI, newItem: OffersUI): Boolean =
        oldItem == newItem
}
