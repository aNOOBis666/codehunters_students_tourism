package com.codehunters.studtour.ui.dormitory

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.data.DormitoryInfo
import com.codehunters.data.RoomInfo
import com.codehunters.studtour.R
import com.codehunters.studtour.adapters.DocumentsAdapter
import com.codehunters.studtour.adapters.RoomsAdapter
import com.codehunters.studtour.adapters.ViewPagerAdapter
import com.codehunters.studtour.databinding.FmtDormitoryBinding
import com.codehunters.studtour.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DormitoryFragment : Fragment(R.layout.fmt_dormitory) {

    companion object {
        private const val DORMITORY_KEY = "dormitory_key"
        private const val EMPTY_LIST_SIZE = 0
        fun getArgs(dormitoryInfo: DormitoryInfo) = bundleOf(DORMITORY_KEY to dormitoryInfo)
    }

    private val viewBinding by viewBinding(FmtDormitoryBinding::bind)
    private val viewModel: DormitoryViewModel by viewModels()

    private val docsAdapter = DocumentsAdapter(::onClickDoc)
    private val roomsAdapter = RoomsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dormitoryItem = (arguments ?: savedInstanceState)?.parcelable(DORMITORY_KEY)
        initHeader()
        initAddress()
        initLivingConditions()
        initIncomingConditions()
        initContacts()
        initDocs()
        initShare()
        viewBinding.rooms.adapter = roomsAdapter
        viewModel.uiState.observe(this, observer = ::initRooms)
        viewModel.failureState.observe(this, observer = ::renderError)
        viewModel.isAuthorized.observe(this, observer = ::renderAuthorized)
    }

    @SuppressLint("SetTextI18n")
    private fun initHeader() = with(viewBinding) {
        viewModel.dormitoryItem?.details?.mainInfo?.photoUrls?.map { photoUrl ->
            PhotosFragment.newInstance(photoUrl)
        }?.let { pages ->
            photos.adapter = ViewPagerAdapter(pages, this@DormitoryFragment)
            pages.size.takeIf { size -> size > 0 }?.let { size ->
                photos.offscreenPageLimit = size
            }
            dotsIndicator.attachTo(photos)
        }
        back.setOnClickListener { viewModel.onShowBack() }
        toolbarTitle.text = viewModel.dormitoryItem?.details?.mainInfo?.name
        title.text = viewModel.dormitoryItem?.details?.mainInfo?.name
        subtitle.text = viewModel.dormitoryItem?.details?.rules?.committee?.name
    }

    @SuppressLint("SetTextI18n")
    private fun initAddress() = with(viewBinding) {
        fullAddress.text =
            "${viewModel.dormitoryItem?.details?.mainInfo?.city}, ${viewModel.dormitoryItem?.details?.mainInfo?.street}, ${viewModel.dormitoryItem?.details?.mainInfo?.houseNumber}"

    }

    @SuppressLint("SetTextI18n")
    private fun initLivingConditions() = with(viewBinding) {
        food.text = viewModel.dormitoryItem?.details?.mainInfo?.mealPlan
        datesRange.text =
            "От ${viewModel.dormitoryItem?.details?.mainInfo?.minDays} до ${viewModel.dormitoryItem?.details?.mainInfo?.maxDays}"
    }

    private fun initIncomingConditions() = with(viewBinding) {
        incomingConditions.text = viewModel.dormitoryItem?.details?.rules?.requiredStudentsDocuments
    }

    private fun initContacts() = with(viewBinding) {
        name.text = viewModel.dormitoryItem?.details?.rules?.committee?.name
        phone.text = viewModel.dormitoryItem?.details?.rules?.committee?.phone
        email.text = viewModel.dormitoryItem?.details?.rules?.committee?.email
    }

    private fun initDocs() = with(viewBinding) {
        documents.adapter = docsAdapter
        docsAdapter.submitList(viewModel.dormitoryItem?.details?.documents)
    }

    private fun onClickDoc(docUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(docUrl))
        startActivity(intent)
    }

    private fun initRooms(roomsList: List<RoomInfo>) {
        val isVisible = roomsList.isNotEmpty()
        viewBinding.rooms.visible(isVisible)
        viewBinding.roomsTitle.visible(isVisible)
        if (isVisible) {
            roomsAdapter.submitList(roomsList)
        }
    }

    private fun renderAuthorized(isVisible: Boolean) {
        viewBinding.booking.visible(isVisible)
        viewBinding.booking.setOnClickListener {
            if (roomsAdapter.itemCount >= EMPTY_LIST_SIZE) viewModel.onShowBooking()
        }
    }

    private fun renderError(throwable: Throwable) {
        viewBinding.root.showSnackbar(throwable.message ?: getString(R.string.error_default_text))
    }

    private fun initShare() {
        viewBinding.share.setOnClickListener {
            val address: String = viewModel.dormitoryItem?.details?.mainInfo?.city + " " + viewModel.dormitoryItem?.details?.mainInfo?.street + " " + viewModel.dormitoryItem?.details?.mainInfo?.houseNumber
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT, viewModel.dormitoryItem?.details?.mainInfo?.name + '\n'
                            + address + '\n' + viewModel.dormitoryItem?.details?.rules?.committee?.email
                )
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }
    }
}