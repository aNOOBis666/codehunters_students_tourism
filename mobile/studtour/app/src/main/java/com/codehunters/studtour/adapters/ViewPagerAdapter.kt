package com.codehunters.studtour.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    private val fragments: List<Fragment> = listOf(),
    fmt: Fragment,
) : FragmentStateAdapter(fmt) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}