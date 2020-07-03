package br.com.breno.brenosocialmedia.viewModel

import android.app.Application
import android.content.Context
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.breno.brenosocialmedia.constants.Constants
import br.com.breno.brenosocialmedia.data.model.Posts
import br.com.breno.brenosocialmedia.data.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel(application: Application): AndroidViewModel(application) {

    val postsLiveData: MutableLiveData<List<Posts>> = MutableLiveData()

    fun fillRecycler() {
        ApiService.postsService.getPosts().enqueue(object : Callback<ArrayList<Posts>>{
            override fun onResponse(call: Call<ArrayList<Posts>>,
                                    response: Response<ArrayList<Posts>>) {
                if (response.isSuccessful) {
                    val post: MutableList<Posts> = mutableListOf()

                    response.body()?.let {postBodyResponse ->
                        for (result in postBodyResponse) {
                            val postList = Posts(
                                title = result.title,
                                body = result.body,
                                id = result.id,
                                userId = result.userId
                            )
                            if (result.id == 10) {
                                break
                            }
                            post.add(postList)
                        }
                    }
                    postsLiveData.value = post
                }
            }

            override fun onFailure(call: Call<ArrayList<Posts>>, t: Throwable) {
            }

        })
    }

    fun getTitleName(context: Context): String? {
        val sharedPreferences = context
            .getSharedPreferences(Constants.Constants.KEY_INFO, Context.MODE_PRIVATE)

        return sharedPreferences.getString(Constants.Constants.KEY_NAME, "")
    }
}