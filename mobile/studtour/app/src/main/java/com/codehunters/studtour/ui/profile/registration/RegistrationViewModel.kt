package com.codehunters.studtour.ui.profile.registration

import androidx.lifecycle.ViewModel
import com.codehunters.studtour.navigation.INavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val navigation: INavigation
): ViewModel() {
}