package xyz.theadityamishra.musictunes.model.remote

class RemoteRepo {
    suspend fun getMusicData(term: String) =
        RetrofitInstance().iTunesAPI.getMusicData(term)
}