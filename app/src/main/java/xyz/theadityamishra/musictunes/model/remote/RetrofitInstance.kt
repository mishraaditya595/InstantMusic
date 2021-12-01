package xyz.theadityamishra.musictunes.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import xyz.theadityamishra.musictunes.model.remote.iTunesAPI

class RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val iTunesAPI: iTunesAPI by lazy {
        retrofit.create(xyz.theadityamishra.musictunes.model.remote.iTunesAPI::class.java)
    }
}