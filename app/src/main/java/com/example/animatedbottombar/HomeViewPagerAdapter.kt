package com.example.animatedbottombar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.animatedbottombar.fragment.HomeFragment
import com.example.animatedbottombar.fragment.ProfileFragment
import com.example.animatedbottombar.fragment.SearchFragment

class HomeViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
               SearchFragment()
            }
            2 -> {
                ProfileFragment()
            }
            else -> {
                HomeFragment()
            }
        }
    }
}