package com.codehunters.studtour.adapters

import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.VhDocItemBinding
import com.codehunters.studtour.utils.inflate

class DocumentsAdapter(
    private val itemClick: (String) -> Unit
) : ListAdapter<String, DocumentsAdapter.DatesViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DocumentsAdapter.DatesViewHolder =
        DatesViewHolder(parent.inflate(R.layout.vh_doc_item))

    override fun onBindViewHolder(
        holder: DatesViewHolder,
        position: Int
    ) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class DatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val viewBinding = VhDocItemBinding.bind(itemView)

        fun bind(item: String) = viewBinding.root.setOnClickListener {
            itemClick(item)
        }
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