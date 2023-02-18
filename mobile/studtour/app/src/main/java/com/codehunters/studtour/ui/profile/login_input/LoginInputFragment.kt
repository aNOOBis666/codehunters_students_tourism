package com.codehunters.studtour.ui.profile.login_input

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.FmtLoginInputBinding
import com.codehunters.studtour.utils.observe
import com.codehunters.studtour.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginInputFragment : Fragment(R.layout.fmt_login_input) {

    private val viewBinding by viewBinding(FmtLoginInputBinding::bind)
    private val viewModel: LoginInputViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            enterButton.setOnClickListener {
                if (email.text?.isNotEmpty() == true && password.text?.isNotEmpty() == true) {
                    viewModel.loginInput(email.text.toString(), password.text.toString())
                }
            }
        }
        viewModel.isAuthorized.observe(this, observer = ::renderAuthorization)
        viewModel.failureState.observe(this, observer = ::renderError)
    }

    private fun renderAuthorization(isAuthorized: Boolean) {
        if (isAuthorized) viewModel.onShowProfile()
    }

    private fun renderError(throwable: Throwable = Throwable(getString(R.string.profile_login_input_incorrect_text))) {
        viewBinding.root.showSnackbar(throwable.message.toString())
    }
}