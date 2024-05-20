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
            if (i == 0) {
                return WelcomeFragment.newInstance(i)
            }else if (i==1){
                return TrackListFragment.newInstance(i)
            }else{
                return HardTrailFragment.newInstance()

            }
        }




    override fun getPageTitle(i: Int): CharSequence? {
             if (i == 0) {
                return "Welcome page"
            }else if (i==1){
                return "Easy Tracks"
            }else{
                return "Hard Tracks"

            }
        }
}