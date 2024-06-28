package com.example.nova.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nova.Adapters.ViewPagerAdapter
import com.example.nova.databinding.ActivityMainBinding
import com.example.nova.fragments.BusinessFragment
import com.example.nova.fragments.EntertainmentFragment
import com.example.nova.fragments.HealthFragment
import com.example.nova.fragments.HomeFragment
import com.example.nova.fragments.ScienceFragment
import com.example.nova.fragments.SearchFragment
import com.example.nova.fragments.SportsFragment
import com.example.nova.fragments.TechnologyFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(HomeFragment())
        fragmentArrayList.add(BusinessFragment())
        fragmentArrayList.add(SportsFragment())
        fragmentArrayList.add(HealthFragment())
        fragmentArrayList.add(ScienceFragment())
        fragmentArrayList.add(TechnologyFragment())
        fragmentArrayList.add(EntertainmentFragment())
        fragmentArrayList.add(SearchFragment())

        val adapter = ViewPagerAdapter(this, supportFragmentManager, fragmentArrayList)
        binding.fabSearch.setOnClickListener {
            binding.fragmentcontainer.currentItem = 8
        }

        binding.fragmentcontainer.adapter = adapter
        binding.include.setupWithViewPager(binding.fragmentcontainer)
    }
}