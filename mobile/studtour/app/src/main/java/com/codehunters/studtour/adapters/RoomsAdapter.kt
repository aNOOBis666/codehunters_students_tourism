package com.codehunters.studtour.adapters

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codehunters.data.RoomInfo
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.VhRoomItemBinding
import com.codehunters.studtour.utils.inflate

class RoomsAdapter: ListAdapter<RoomInfo, RoomsAdapter.RoomViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RoomsAdapter.RoomViewHolder =
        RoomViewHolder(parent.inflate(R.layout.vh_room_item))

    override fun onBindViewHolder(
        holder: RoomViewHolder,
        position: Int
    ) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding = VhRoomItemBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(item: RoomInfo) {
            with(viewBinding) {
                livingType.text = item.details.mainInfo?.type
                available.text = "Комнат доступно: ${item.details.mainInfo?.amount}"
                cost.text = "${item.details.mainInfo?.price} ₽/ночь"
                description.text = item.details.mainInfo?.description
            }
         }
    }

    private object DiffCallback : DiffUtil.ItemCallback<RoomInfo>() {
        override fun areItemsTheSame(
            oldItem: RoomInfo,
            newItem: RoomInfo,
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: RoomInfo,
            newItem: RoomInfo
        ): Boolean = oldItem == newItem
    }
}