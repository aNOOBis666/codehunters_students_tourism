package com.codehunters.studtour.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.codehunters.studtour.R
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

@ActivityRetainedScoped
class NavDispatcher {

    private val navigationCommandMutableSharedFlow = MutableSharedFlow<NavigationCommand>()
    val navigationCommandFlow: Flow<NavigationCommand> by ::navigationCommandMutableSharedFlow

    private val navigationResetSharedFlow = MutableSharedFlow<Int>(0)
    val navigationResetFlow: Flow<Int> by ::navigationResetSharedFlow

    //  TODO Try to use Safe Args for navigate

    suspend fun navigate(
        @IdRes destinationId: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null
    ) {
        emit { navController ->
            navController.navigate(destinationId, args, navOptions, navigatorExtras)
        }
    }

    suspend fun back() =
        emit { navController ->
            navController.popBackStack()
        }

    suspend fun backTo(@IdRes destinationId: Int, inclusive: Boolean = false) {
        emit { navController ->
            navController.popBackStack(destinationId, inclusive)
        }
    }

    private suspend fun emit(command: NavigationCommand) {
        navigationCommandMutableSharedFlow.emit(command)
    }
}

typealias NavigationCommand = (NavController) -> Unit