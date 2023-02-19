package com.codehunters.studtour.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codehunters.data.DormitoryInfo
import com.codehunters.data.EntitiesData
import com.codehunters.data.EntityType
import com.codehunters.data.LabInfo
import com.codehunters.studtour.R
import com.codehunters.studtour.adapters.viewholders.DormitoryViewHolder
import com.codehunters.studtour.adapters.viewholders.LabVIewHolder
import com.codehunters.studtour.utils.inflate

class DestinationsAdapter(
    private val itemClick: (EntitiesData) -> Unit
) : ListAdapter<EntitiesData, RecyclerView.ViewHolder>(
    DiffCallback
) {

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is DormitoryInfo -> EntityType.DORMITORY_TYPE.ordinal
        is LabInfo -> EntityType.LABS_TYPE.ordinal
        else -> EntityType.DORMITORY_TYPE.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            EntityType.DORMITORY_TYPE.ordinal -> DormitoryViewHolder(
                parent.inflate(R.layout.vh_dormitory_item),
                itemClick
            )
            EntityType.LABS_TYPE.ordinal -> LabVIewHolder(
                parent.inflate(R.layout.vh_lab_item),
                itemClick
            )
            else -> DormitoryViewHolder(
                parent.inflate(R.layout.vh_dormitory_item),
                itemClick
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DormitoryViewHolder -> holder.bind(getItem(position))
            is LabVIewHolder -> holder.bind(getItem(position))
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<EntitiesData>() {
        override fun areItemsTheSame(
            oldItem: EntitiesData,
            newItem: EntitiesData,
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: EntitiesData,
            newItem: EntitiesData
        ): Boolean = oldItem == newItem
    }
}