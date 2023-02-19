package com.codehunters.studtour.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.VhPhotoItemBinding
import com.codehunters.studtour.utils.inflate
import com.codehunters.studtour.utils.loadImage

class PhotosAdapter: ListAdapter<String, PhotosAdapter.PhotosViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotosAdapter.PhotosViewHolder =
        PhotosViewHolder(parent.inflate(R.layout.vh_photo_item))

    override fun onBindViewHolder(
        holder: PhotosViewHolder,
        position: Int
    ) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding = VhPhotoItemBinding.bind(itemView)

        fun bind(item: String) = viewBinding.root.loadImage(item)
    }

    private object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String,
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean = oldItem == newItem
    }
}