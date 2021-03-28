package com.example.dietcentral

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // handle button activities
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.settingsbutton) {
            setCurrentFragment(fragment_settings())
        } else if (id == R.id.timerbutton) {
            setCurrentFragment(fragment_timer())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }


}