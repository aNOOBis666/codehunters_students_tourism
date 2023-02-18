package com.codehunters.studtour.modules

import com.codehunters.presenter.interfaces.IAuthPresenter
import com.codehunters.presenter.interfaces.IStudTourPresenter
import com.codehunters.studtour.interactors.AppInteractor
import com.codehunters.studtour.navigation.INavigation
import com.codehunters.studtour.navigation.NavDispatcher
import com.codehunters.studtour.navigation.Navigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApp(authPresenter: IAuthPresenter) =
        AppInteractor(authPresenter)

    @Singleton
    @Provides
    fun provideNavigationDispatcher() = NavDispatcher()

    @Singleton
    @Provides
    fun provideNavigation(
        navigationDispatcher: NavDispatcher
    ): INavigation = Navigation(navigationDispatcher)
}