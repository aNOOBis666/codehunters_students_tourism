package com.codehunters.studtour.ui.profile

import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.FmtProfileBinding
import com.codehunters.studtour.databinding.ItemProfileBinding
import com.codehunters.studtour.utils.observe
import com.codehunters.studtour.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fmt_profile) {

    private val viewBinding by viewBinding(FmtProfileBinding::bind)
    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            favoriteItem.setContent(
                R.drawable.v_ic_item_favorites,
                R.string.profile_favorite_item_title
            ) { viewModel.onShowFavorites() }
            notificationItem.setContent(
                R.drawable.v_ic_item_notifications,
                R.string.profile_notification_item_title
            ) { viewModel.onShowReminders() }
        }
        viewModel.isAuthorized.observe(this, observer = ::renderAuthorization)
    }

    private fun renderAuthorization(isAuthorized: Boolean) {
        viewBinding.authButton.text = getString(
            if (!isAuthorized) R.string.profile_button_login_text
            else R.string.profile_button_logout_text
        )
        viewBinding.userItem.setContent(
            R.drawable.v_ic_profile,
            R.string.profile_user_item_title,
            isAuthorized
        ) { viewModel.onShowUserData() }
        viewBinding.authButton.setOnClickListener{ viewModel.onAuthCLick(isAuthorized) }
    }

    private fun ItemProfileBinding.setContent(
        @DrawableRes ivResourceId: Int,
        @StringRes titleResId: Int,
        isVisible: Boolean = true,
        onClick: () -> Unit
    ) {
        itemLogo.setImageResource(ivResourceId)
        title.text = getString(titleResId)
        root.visible(isVisible)
        root.setOnClickListener { onClick() }
    }
}