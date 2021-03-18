package com.example.dietcentral

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment=HomeFragment()
        val secondFragment=InfoFragment()
        val thirdFragment=DietFragment()

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val info = findViewById<View>(R.id.infolayout)
        setCurrentFragment(firstFragment)
        bottomNav.selectedItemId = R.id.nav_home;
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->setCurrentFragment(firstFragment)
                R.id.nav_info->setCurrentFragment(secondFragment)
                R.id.nav_diet->setCurrentFragment(thirdFragment)

            }
            true
        }

//        val button = findViewById<Button>(R.id.plant_based_diets)
//        button.setOnClickListener {
//            setCurrentFragment(thirdFragment)
//        }

    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }


}