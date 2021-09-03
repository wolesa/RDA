package com.wj.demoapp821.view.brewerieslist

import androidx.recyclerview.widget.DiffUtil
import com.wj.domain.model.Brewery

object BreweriesAdapterDiffCallback : DiffUtil.ItemCallback<Brewery>() {

    override fun areItemsTheSame(oldItem: Brewery, newItem: Brewery) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Brewery, newItem: Brewery) = oldItem == newItem

}