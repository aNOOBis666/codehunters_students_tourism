package com.codehunters.studtour.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.codehunters.data.EntitiesData
import com.codehunters.studtour.databinding.VhLabItemBinding

class LabVIewHolder(
    itemView: View,
    private val itemClick: (EntitiesData) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding = VhLabItemBinding.bind(itemView)

    fun bind(item: EntitiesData) = with(viewBinding) {
        root.setOnClickListener { itemClick(item) }
    }
}