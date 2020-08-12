package com.example.pokemondownloader

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : AppCompatActivity(){

    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navigationController)


    }

    override fun onSupportNavigateUp(): Boolean {
        navigationController.navigateUp()
        return super.onSupportNavigateUp()
    }

}