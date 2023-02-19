package com.codehunters.studtour.ui.booking

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.data.DormitoryInfo
import com.codehunters.data.RoomInfo
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.FmtBookingBinding
import com.codehunters.studtour.utils.*
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookingFragment : Fragment(R.layout.fmt_booking) {

    companion object {
        private const val BOOKING_ROOM_KEY = "booking_rooms_key"
        private const val BOOKING_DORMITORY_KEY = "booking_dormitory_key"
        fun getArgs(roomsList: List<RoomInfo>, dormitoryInfo: DormitoryInfo) = bundleOf(
            BOOKING_ROOM_KEY to roomsList,
            BOOKING_DORMITORY_KEY to dormitoryInfo
        )
    }

    private val viewBinding by viewBinding(FmtBookingBinding::bind)
    private val viewModel: BookingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.roomsList =
            (arguments ?: savedInstanceState)?.parcelableArrayList(BOOKING_ROOM_KEY)
        viewModel.dormitory = (arguments ?: savedInstanceState)?.parcelable(BOOKING_DORMITORY_KEY)

        initHeader()
        initRadioButtons()
        initRoomTypes()
        initDates()
        viewBinding.back.setOnClickListener { viewModel.onShowDormitory() }
        viewBinding.submit.setOnClickListener {
            if (viewModel.selectedStartDate != null && viewModel.selectedEndDate != null && viewModel.selectedType != null) {
                val selectedItem = viewModel.roomsList?.find { it.details.mainInfo?.type == viewModel.selectedType }
                viewModel.onBookRoom(selectedItem?.id ?: String())
                viewModel.onSetReminder(selectedItem?.id ?: String())
                viewModel.onShowDormitory()
            } else {
                viewBinding.root.showSnackbar(getString(R.string.booking_empty_field))
            }
        }
    }

    private fun initHeader() {
        with(viewBinding) {
            dormitoryPoster.loadImage(viewModel.dormitory?.details?.mainInfo?.photoUrls?.firstOrNull())
            dormitoryName.text = viewModel.dormitory?.details?.mainInfo?.name
        }
    }

    private fun initRadioButtons() {
        with(viewBinding.firstStep) {
            studentButton.setOnClickListener {
                setCheck(true)
            }
            organizationButton.setOnClickListener {
                setCheck(false)
            }
        }
    }

    private fun initRoomTypes() {
        val types = viewModel.roomsList?.map { it.details.mainInfo?.type }
        val adapter = viewBinding.root.context?.let { context ->
            types?.let { types ->
                ArrayAdapter(context, R.layout.vh_spinner_item, types)
            }
        }
        adapter?.setDropDownViewResource(R.layout.vh_spinner_item)
        with(viewBinding.firstStep) {
            roomType.adapter = adapter
            roomType.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    p0?.setSelection(p2)
                    viewModel.selectedType = viewBinding.firstStep.roomType.selectedItem as? String
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
        }
    }

    private fun setCheck(isStudent: Boolean) = with(viewBinding.firstStep) {
        studentButton.isChecked = isStudent
        organizationButton.isChecked = !isStudent
    }

    private fun initDates() {
        viewBinding.firstStep.datesRangeFrame.setOnClickListener {
            datePickerDialog()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun datePickerDialog() {
        val datePickerDialog = with(MaterialDatePicker.Builder.dateRangePicker()) {
            setTitleText(getString(R.string.booking_choose_date))
            setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
            build()
        }
        datePickerDialog.show(parentFragmentManager, datePickerDialog.toString())
        datePickerDialog.addOnPositiveButtonClickListener {
            datePickerDialog.selection?.let { date ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    viewModel.selectedStartDate = convertTimeToFormat(date.first, "yyyy-MM-dd")
                    viewModel.selectedEndDate = convertTimeToFormat(date.second, "yyyy-MM-dd")
                }
                viewBinding.firstStep.datesRange.text =
                    "${viewModel.selectedStartDate} - ${viewModel.selectedEndDate}"
            }
        }
    }
}