package br.com.breno.brenosocialmedia.data.extension

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> callback(success:((Response<T>) -> Unit)?, failure: ((throwable: Throwable) -> Unit)? = null):Callback<T> {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) { success?.invoke(response) }
        override fun onFailure(call: Call<T>, t: Throwable) { failure?.invoke(Throwable(t)) }
    }
}