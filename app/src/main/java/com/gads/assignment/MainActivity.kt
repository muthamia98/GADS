package com.gads.assignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.gads.assignment.submit.SubmitActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        viewPager = findViewById(R.id.leadersPager)
        viewPager.adapter = LeadersPagerAdapter(this)
        val tabLayout = findViewById<TabLayout>(R.id.leadersTabs)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabTitles = arrayOf("Learning Leaders", "Skill IQ Leaders")
            tab.text = tabTitles[position]
        }.attach()

        val submitButton = findViewById<AppCompatButton>(R.id.submitProjectButton)
        submitButton.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
        }
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }
}
