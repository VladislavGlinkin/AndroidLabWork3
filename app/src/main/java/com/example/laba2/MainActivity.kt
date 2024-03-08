package com.example.laba2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.laba2.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ItemDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.list -> {
                    when (navController.currentDestination?.id) {
                        R.id.detailFragment -> {
                            navController.navigate(R.id.action_detailFragment_to_listFragment)
                        }
                        R.id.editFragment -> {
                            navController.navigate(R.id.action_editFragment_to_listFragment)
                        }
                    }
                    true
                }
                else -> false
            }
        }

    }
}