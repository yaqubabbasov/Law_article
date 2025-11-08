package com.yaqubabbasov.law_article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.yaqubabbasov.law_article.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navhost = supportFragmentManager.findFragmentById(R.id.navhost)as NavHostFragment
        val nav = navhost.navController
        NavigationUI.setupWithNavController(binding.bottom,nav)
        nav.addOnDestinationChangedListener{_,destination,_, ->
            when(destination.id){
                R.id.detailsFragment,R.id.splashFragment,R.id.loginFragment,R.id.registerFragment ->binding.cardView.visibility=View.GONE
                else->binding.cardView.visibility=View.VISIBLE
            }
        }

    }
}