package xyz.theadityamishra.musictunes.model.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface iTunesAPI {

    @GET("search?")
    suspend fun getMusicData(
        @Query("term") term: String
    ): iTunesModel

}