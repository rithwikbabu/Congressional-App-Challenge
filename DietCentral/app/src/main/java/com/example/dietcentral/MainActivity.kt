package com.example.dietcentral

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment=HomeFragment()
        val secondFragment=InfoFragment()
        val thirdFragment=DietFragment()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        setCurrentFragment(firstFragment)

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->setCurrentFragment(firstFragment)
                R.id.nav_info->setCurrentFragment(secondFragment)
                R.id.nav_diet->setCurrentFragment(thirdFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }

}