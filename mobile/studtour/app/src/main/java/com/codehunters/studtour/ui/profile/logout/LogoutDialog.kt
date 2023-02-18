package com.codehunters.studtour.ui.profile.logout

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.codehunters.studtour.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogoutDialog : DialogFragment() {

    private val viewModel: LogoutViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogStyle)
            .apply {
                setTitle(this)
                setMessage(this)
                setPositiveButton(this)
                setNegativeButton(this)
            }.create()
    }

    private fun setTitle(dialogBuilder: MaterialAlertDialogBuilder) =
        dialogBuilder.setTitle(getString(R.string.profile_dialog_logout_title))

    private fun setMessage(dialogBuilder: MaterialAlertDialogBuilder) =
        dialogBuilder.setMessage(getString(R.string.profile_dialog_logout_message))

    private fun setPositiveButton(dialogBuilder: MaterialAlertDialogBuilder) =
        dialogBuilder.setPositiveButton(getString(R.string.profile_dialog_logout_positive_button)) { dialogInterface, _ ->
            viewModel.logout()
            dialogInterface.cancel()
        }

    private fun setNegativeButton(dialogBuilder: MaterialAlertDialogBuilder) =
        dialogBuilder.setNegativeButton(getString(R.string.profile_dialog_logout_negative_button)) { dialogInterface, _ ->
            dialogInterface.cancel()
        }
}