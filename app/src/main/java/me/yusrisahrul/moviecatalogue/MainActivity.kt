package me.yusrisahrul.moviecatalogue

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import me.yusrisahrul.moviecatalogue.ui.favorite.FavoriteFragment
import me.yusrisahrul.moviecatalogue.ui.movie.MovieFragment
import me.yusrisahrul.moviecatalogue.ui.tvshow.TvShowFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setFragment(MovieFragment())

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_movie, R.id.navigation_tv_show, R.id.navigation_favorite
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        nav_view.setOnNavigationItemSelectedListener {item ->
//            when (item.itemId) {
//                nav_view.selectedItemId -> return@setOnNavigationItemSelectedListener false
//
//                R.id.navigation_movie -> {
//                    setFragment(MovieFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//
//                R.id.navigation_tv_show -> {
//                    setFragment(TvShowFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//
//                R.id.navigation_favorite -> {
//                    setFragment(FavoriteFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//            }
//            return@setOnNavigationItemSelectedListener false
//        }

    }

//    private fun setFragment(fragment: Fragment) {
//        with(supportFragmentManager.beginTransaction()) {
//            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            replace(R.id.nav_host_fragment, fragment)
//            commit()
//        }
//    }
}
