package com.codehunters.studtour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.studtour.databinding.AcHostBinding
import com.codehunters.studtour.navigation.NavDispatcher
import com.codehunters.studtour.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HostActivity : AppCompatActivity(R.layout.ac_host) {

    @Inject
    lateinit var navigationDispatcher: NavDispatcher

    private val viewBinding by viewBinding(AcHostBinding::bind)

    private val navController: NavController by lazy {
        (supportFragmentManager.findFragmentById(R.id.host_container) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationDispatcher.navigationCommandFlow.observe(this) { command ->
            command.invoke(navController)
        }
        viewBinding.bottomNavBar.setupWithNavController(navController)
    }
}