package com.codehunters.studtour.ui.dormitory

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.VhPhotoItemBinding
import com.codehunters.studtour.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment: Fragment(R.layout.vh_photo_item) {

    companion object {
        private const val PAGE = "page"

        fun newInstance(photo: String) =
            PhotosFragment().apply {
                arguments = bundleOf(PAGE to photo)
            }
    }

    private val viewBinding by viewBinding(VhPhotoItemBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(PAGE)?.let { posterUrl ->
            viewBinding.root.loadImage(posterUrl)
        }
    }
}