package br.com.breno.brenosocialmedia.activity

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.breno.brenosocialmedia.presentation.activities.LoginActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    companion object {
        val USERNAME_CORRETO: String = "Bret"
        val USERNAME_ERRADO: String = "Breno"
        val ERRO_USERNAME_INVALIDO: String = "User not found"
        val ERRO_CAMPO_VAZIO: String = "Null or Blank"
    }

    //@get:Rule
    //val intentsTestRule = IntentsTestRule(LoginActivity::class.java)

}