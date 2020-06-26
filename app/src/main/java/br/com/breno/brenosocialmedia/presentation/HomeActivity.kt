package br.com.breno.brenosocialmedia.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.viewModel.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var mViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigationConfigure()
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