package io.github.kurramkurram.template.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import io.github.kurramkurram.template.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(findViewById(R.id.nav_host_fragment))
        setupWithNavController(bottom_navigation, navController)
    }
}