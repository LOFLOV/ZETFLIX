package com.android.zetflix

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.zetflix.injection.DaggerApplicationComponent
import com.android.zetflix.network.CinemaApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var cinemaApi: CinemaApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerApplicationComponent.create().inject(this)

        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.favoritesFragment,
                R.id.ratingsFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        GlobalScope.launch(Dispatchers.IO) {
            val movie = cinemaApi.getMoviesExample("be5716c3a4c1abba6b0f914c853edcf4")
            Log.d("TAG", movie.toString())
        }

        GlobalScope.launch(Dispatchers.IO) {
            val movieResponse = cinemaApi.getMovies("be5716c3a4c1abba6b0f914c853edcf4")
            Log.d("TAG2", movieResponse.toString())

            movieResponse.results.forEach { movie ->
                Log.d("TAG3", "${movie.title}\n")
            }

        }
    }
}