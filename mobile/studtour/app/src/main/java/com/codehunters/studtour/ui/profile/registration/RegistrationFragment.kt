package com.codehunters.studtour.ui.profile.registration

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.studtour.R
import com.codehunters.studtour.databinding.FmtRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment: Fragment(R.layout.fmt_registration) {

    companion object {
        private const val REGISTRATION_STEP_KEY = "registration_step_key"
        private const val FIRST_STEP = 0
        private const val SECOND_STEP = 0
        private const val THIRD_STEP = 0

        fun getArgs(stepNum: Int) = bundleOf(REGISTRATION_STEP_KEY to stepNum)
    }

    private val viewBinding by viewBinding(FmtRegistrationBinding::bind)
    private val viewModel: RegistrationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.stepNum = (arguments ?: savedInstanceState)?.getInt(REGISTRATION_STEP_KEY)
        when (viewModel.stepNum) {
            FIRST_STEP -> renderFirstStep()
            SECOND_STEP -> renderSecondStep()
            THIRD_STEP -> renderThirdStep()
        }
        with(viewBinding) {
            back.setOnClickListener { viewModel.onShowPrevious() }
        }
    }

    private fun renderFirstStep() = with(viewBinding.firstStep) {
        viewBinding.enterButton.setOnClickListener {
            if (email.text?.isNotEmpty() == true && password.text?.isNotEmpty() == true) {
                viewModel.registerUser(email.text.toString(), password.text.toString())
            }
        }
    }

    private fun renderSecondStep() {

    }
    private fun renderThirdStep(){

    }
}