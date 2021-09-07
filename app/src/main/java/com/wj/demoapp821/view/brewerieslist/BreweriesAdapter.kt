package com.wj.demoapp821.view.brewerieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wj.demoapp821.R
import com.wj.demoapp821.common.RecyclerViewOnClickListener
import com.wj.domain.model.Brewery

class BreweriesAdapter(private val onClickListener: RecyclerViewOnClickListener<Brewery>) :
    ListAdapter<Brewery, BreweriesAdapter.BreweryViewHolder>(BreweriesAdapterDiffCallback) {

    class BreweryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val breweryName = view.findViewById<TextView>(R.id.breweryName)
        private val breweryCountry = view.findViewById<TextView>(R.id.breweryCountry)

        fun bind(brewery: Brewery) {
            breweryName.text = brewery.name
            breweryCountry.text = brewery.country
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BreweryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.breweries_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        val item = getItem(position)
        holder.run {
            bind(item)
            itemView.setOnClickListener { onClickListener.onItemClick(item) }
        }
    }
}