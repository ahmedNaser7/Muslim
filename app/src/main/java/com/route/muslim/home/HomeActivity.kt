package com.route.muslim.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.route.muslim.R
import com.route.muslim.databinding.ActivityMainBinding
import com.route.muslim.home.tabs.hadeth.HadethFragment
import com.route.muslim.home.tabs.quran.QuranFragment
import com.route.muslim.home.tabs.athkar.AthkarFragment
import com.route.muslim.home.tabs.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        handleNavbar()
    }

    private fun handleNavbar() {
        val navbar = viewBinding.content.navBar
        navbar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.quran_item -> {
                    showFragment(QuranFragment())
                    true
                }

                R.id.hadeth_item -> {
                    showFragment(HadethFragment())
                    true
                }

                R.id.sebha_item -> {
                    showFragment(SebhaFragment())
                    true
                }

                R.id.athkar_item -> {
                    showFragment(AthkarFragment())
                    true
                }

                else -> false
            }
        }
        viewBinding.content.navBar.selectedItemId = R.id.quran_item
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fade_in_animation, R.anim.fade_out_animation)
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()

    }


    private fun initView() {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}