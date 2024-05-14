package com.example.mountain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
        override fun getCount(): Int  = 3

        override fun getItem(i: Int): Fragment {
            val fragment = TrackDetailFragment()

            fragment.arguments = Bundle().apply {
                putInt("object", i + 1)
            }

            return fragment
        }

        override fun getPageTitle(position: Int): CharSequence {
            return "Strona ${(position + 1)}"
        }
}