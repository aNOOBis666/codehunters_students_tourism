package com.codehunters.studtour.ui.profile.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.FmtLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment(R.layout.fmt_login) {

    private val viewBinding by viewBinding(FmtLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            registration.setOnClickListener { viewModel.onShowRegistration() }
            authorize.setOnClickListener { viewModel.onShowLogin() }
        }
    }
}