package com.codehunters.studtour.modules

import android.content.Context
import com.codehunters.presenter.ReminderPresenter
import com.codehunters.presenter.interfaces.IAuthPresenter
import com.codehunters.presenter.interfaces.IReminderPresenter
import com.codehunters.studtour.interactors.AppInteractor
import com.codehunters.studtour.interactors.IReminderService
import com.codehunters.studtour.interactors.ReminderService
import com.codehunters.studtour.navigation.INavigation
import com.codehunters.studtour.navigation.NavDispatcher
import com.codehunters.studtour.navigation.Navigation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideReminderService(
        @ApplicationContext context: Context,
        reminderPresenter: IReminderPresenter
    ): IReminderService = ReminderService(context, reminderPresenter)
}