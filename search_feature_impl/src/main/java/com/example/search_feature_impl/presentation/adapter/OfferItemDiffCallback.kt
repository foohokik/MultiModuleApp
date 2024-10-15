package com.example.search_feature_impl.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.search_feature_impl.presentation.model.OfferUI

internal class OfferItemDiffCallback : DiffUtil.ItemCallback<OfferUI>() {

    override fun areItemsTheSame(oldItem: OfferUI, newItem: OfferUI): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: OfferUI, newItem: OfferUI): Boolean =
        oldItem == newItem
}