package br.com.breno.brenosocialmedia.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.breno.brenosocialmedia.R
import br.com.breno.brenosocialmedia.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var viewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        setListeners()
        observers()
    }

    override fun onClick(v: View) {
        val id = v.id
        if(id == R.id.btn_login) {
            viewModel.checkUser(et_user.text.toString())
        }
    }

    private fun setListeners() {
        btn_login.setOnClickListener(this)
    }

    private fun observers(){
        viewModel.postsLiveData.observe(this, Observer {
            if (it) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            } else {
                Toast.makeText(applicationContext, "Login incorreto",
                    Toast.LENGTH_SHORT).show()
            }
        })
    }

}
