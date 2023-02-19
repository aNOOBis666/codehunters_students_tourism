package com.codehunters.studtour.interactors

import com.codehunters.presenter.interfaces.IAuthPresenter
import kotlinx.coroutines.flow.Flow

class AppInteractor(
    private val authPresenter: IAuthPresenter
) {
    val isAuthorized: Flow<Boolean>
        get() = authPresenter.isAuthorized

    suspend fun logOut() = authPresenter.logOut()

}