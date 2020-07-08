package br.com.breno.brenosocialmedia.presentation.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.presentation.fragments.AlbumFragment
import br.com.breno.brenosocialmedia.presentation.fragments.MapsFragment
import br.com.breno.brenosocialmedia.presentation.fragments.PostsFragment
import br.com.breno.brenosocialmedia.viewModel.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var mViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigationConfigure()
        val postsFragment = PostsFragment()
        val albumFragment = AlbumFragment()
        val mapsFragment = MapsFragment()

        setCurrentFragment(postsFragment)

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_posts -> setCurrentFragment(postsFragment)
                R.id.navigation_album -> setCurrentFragment(albumFragment)
                R.id.navigation_maps -> setCurrentFragment(mapsFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }

    private fun navigationConfigure() {
        navigation.apply {
            setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { true })
            selectedItemId = R.id.navigation_posts
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}
