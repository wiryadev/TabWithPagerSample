package com.wiryadev.tabwithpagersample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        val title = MainActivity.tabTitlesResource[position]
        return when (position) {
            0 -> ChatsFragment.newInstance(title)
            1 -> CallsFragment.newInstance(title)
            else -> throw IllegalStateException()
        }
    }

    override fun getItemCount(): Int = MainActivity.tabTitlesResource.size

}