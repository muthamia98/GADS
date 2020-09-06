package com.gads.assignment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gads.assignment.hours.LearningLeadersFragment
import com.gads.assignment.skilliq.SkillIQLeadersFragment

class LeadersPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> LearningLeadersFragment.newInstance()
        1 -> SkillIQLeadersFragment.newInstance()
        else -> throw IllegalStateException()
    }

}
