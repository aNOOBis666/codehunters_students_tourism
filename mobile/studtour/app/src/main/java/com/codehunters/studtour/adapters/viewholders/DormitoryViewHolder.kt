package com.codehunters.studtour.adapters.viewholders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.codehunters.data.DormitoryInfo
import com.codehunters.data.EntitiesData
import com.codehunters.studtour.databinding.VhDormitoryItemBinding
import com.codehunters.studtour.utils.loadImage

class DormitoryViewHolder(
    itemView: View,
    private val itemClick: (EntitiesData) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding = VhDormitoryItemBinding.bind(itemView)

    @SuppressLint("SetTextI18n")
    fun bind(item: EntitiesData) = with(viewBinding) {
        val dormitoryItem = item as? DormitoryInfo
        poster.loadImage(dormitoryItem?.details?.mainInfo?.photoUrls?.first())
        title.text = dormitoryItem?.details?.mainInfo?.name
        subTitle.text = dormitoryItem?.details?.rules?.committee?.name
        place.text = dormitoryItem?.details?.mainInfo?.city
        datesRange.text =
            "От ${dormitoryItem?.details?.mainInfo?.minDays} до ${dormitoryItem?.details?.mainInfo?.maxDays}"
        root.setOnClickListener { itemClick(item) }
    }
}