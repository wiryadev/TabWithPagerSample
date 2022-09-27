package com.wiryadev.tabwithpagersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.wiryadev.tabwithpagersample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabs = binding.tabs
        val homePagerAdapter = HomePagerAdapter(this)
        viewPager.adapter = homePagerAdapter

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = getString(tabTitlesResource[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

    companion object {
        val tabTitlesResource = intArrayOf(
            R.string.chats,
            R.string.calls,
        )
    }
}