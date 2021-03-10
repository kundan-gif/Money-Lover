package com.example.moneylover.views

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.moneylover.R
import com.example.moneylover.views.bottomnavigation.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(Fragment())
        fragmentManager = supportFragmentManager

        val bottomNavigationView =
            findViewById<View>(R.id.bottomNavigation) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(this)



    }

    private fun loadFragment(navigationFragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.rlContainerForBottomNavigation,
            navigationFragment
        ).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var navigationFragment: Fragment? = null
        when (item.itemId) {
            R.id.navigationTransactions -> {
                navigationFragment = TransactionFragment()
            }
            R.id.navigationReport -> {
                navigationFragment = ReportFragment()
            }
            R.id.navigationAddTransaction -> {
                navigationFragment = AddTransactionFragment()
            }
            R.id.navigationPlanning -> {
                navigationFragment = PlanningFragment()
            }
            R.id.navigationAccount -> {
                navigationFragment = AccountFragment()
            }

        }
        if (navigationFragment != null) {
            loadFragment(navigationFragment)
        }
        return true
    }

}