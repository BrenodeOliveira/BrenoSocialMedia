package br.com.breno.brenosocialmedia.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.constants.Constants
import br.com.breno.brenosocialmedia.viewModel.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setListeners()
        observers()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.btn_login) {
            viewModel.checkUser(et_user.text.toString())
        }
    }

    private fun setListeners() {
        btn_login.setOnClickListener(this)
    }

    private fun observers() {
        viewModel.postsLiveData.observe(this, Observer {
            when {
                it.equals(1) -> {
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                }
                it.equals(2) -> {
                    Snackbar.make(
                        constraint_card, Constants.Constants.EMPTY_FIELD,
                        Snackbar.LENGTH_LONG).show()
                }
                it.equals(3) -> {
                    Snackbar.make(
                        constraint_card, Constants.Constants.INTERNET_ERROR,
                        Snackbar.LENGTH_LONG).show()
                }
                else -> {
                    Snackbar.make(
                        constraint_card, Constants.Constants.LOGIN_ERROR,
                        Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }

}
