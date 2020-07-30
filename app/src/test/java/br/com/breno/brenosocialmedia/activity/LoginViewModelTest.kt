package br.com.breno.brenosocialmedia.activity

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.viewModel.LoginViewModel
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import okhttp3.internal.notify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LoginViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun `when API result is success in viewModel`(){
        whenever(viewModel.postsLiveData).thenReturn(MutableLiveData(1))

        viewModel.checkUser("Bret")

        assertEquals(Unit, viewModel.checkUser("Bret"))

        verify(viewModel).postsLiveData.value
    }

    @Test
    fun testEquals() {
        assertEquals(4, 2+2)
    }
}