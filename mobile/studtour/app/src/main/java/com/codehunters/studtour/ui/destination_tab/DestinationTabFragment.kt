package com.codehunters.studtour.ui.destination_tab

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.codehunters.studtour.R
import com.codehunters.studtour.adapters.ViewPagerAdapter
import com.codehunters.studtour.databinding.FmtDestinationTabBinding
import com.codehunters.studtour.ui.destination_list.DestinationListFragment
import com.codehunters.studtour.ui.destination_list.DestinationListFragment.Companion.SELECTED_TAB_KEY
import com.codehunters.studtour.ui.destination_list.DestinationListViewModel.Companion.DORMITORIES_TAB_POSITION
import com.codehunters.studtour.ui.destination_list.DestinationListViewModel.Companion.SCIENCE_TAB_POSITION
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DestinationTabFragment : Fragment(R.layout.fmt_destination_tab) {

    private val viewBinding by viewBinding(FmtDestinationTabBinding::bind)

    private var tabMediator: TabLayoutMediator? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabFragments = listOf(
            DestinationListFragment().apply { arguments = bundleOf(SELECTED_TAB_KEY to DORMITORIES_TAB_POSITION) },
            DestinationListFragment().apply { arguments = bundleOf(SELECTED_TAB_KEY to SCIENCE_TAB_POSITION) }
        )
        with(viewBinding) {
            viewPager.isUserInputEnabled = false
            viewBinding.viewPager.adapter =
                ViewPagerAdapter(tabFragments, this@DestinationTabFragment)
            tabMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when (position) {
                    DORMITORIES_TAB_POSITION -> getString(R.string.destination_dormitories)
                    SCIENCE_TAB_POSITION -> getString(R.string.destination_science)
                    else -> null
                }
            }.apply {
                attach()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tabMediator?.detach()
        tabMediator = null
        viewBinding.viewPager.adapter = null
    }
}