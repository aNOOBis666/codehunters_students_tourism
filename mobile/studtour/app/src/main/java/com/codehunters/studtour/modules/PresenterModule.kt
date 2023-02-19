package com.codehunters.studtour.modules

import com.codehunters.presenter.AuthPresenter
import com.codehunters.presenter.ReminderPresenter
import com.codehunters.presenter.StudTourPresenter
import com.codehunters.presenter.interfaces.IAuthPresenter
import com.codehunters.presenter.interfaces.IReminderPresenter
import com.codehunters.presenter.interfaces.IStudTourPresenter
import com.codehunters.repository.auth.IAuthRepository
import com.codehunters.repository.data_store.IDataStoreRepository
import com.codehunters.repository.reminders.IRemindersRepository
import com.codehunters.repository.stud_tour.IStudTourRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PresenterModule {

    @Provides
    @Singleton
    fun provideStudTourPresenter(studTourRepository: IStudTourRepository): IStudTourPresenter =
        StudTourPresenter(studTourRepository)

    @Provides
    @Singleton
    fun provideAuthPresenter(
        studTourRepository: IStudTourRepository,
        authRepository: IAuthRepository,
        dataStoreRepository: IDataStoreRepository
    ): IAuthPresenter =
        AuthPresenter(authRepository, studTourRepository, dataStoreRepository)

    @Provides
    @Singleton
    fun provideReminderPresenter(
        reminderRepository: IRemindersRepository
    ): IReminderPresenter = ReminderPresenter(reminderRepository)
}