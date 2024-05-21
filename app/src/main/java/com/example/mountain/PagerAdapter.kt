package com.example.mountain

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getCount(): Int  {
        return 3
    }
    override fun getItem(i: Int): Fragment {
        return when (i) {
            0 -> WelcomeFragment.newInstance(i)
            1 -> TrackListFragment.newInstance(i)
            else -> TrackListFragment.newInstance(i)
        }
    }
    override fun getPageTitle(i: Int): CharSequence? {
        return when (i) {
            0 -> "Welcome page"
            1 -> "Easy Trails"
            else -> "Hard Trails"
        }
    }
}