package xyz.theadityamishra.musictunes.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.theadityamishra.musictunes.model.remote.RemoteRepo
import xyz.theadityamishra.musictunes.model.remote.iTunesModel

public class ViewModel(context: Context, private val remoteRepo: RemoteRepo): ViewModel() {
    val musicApiResponse = MutableLiveData<iTunesModel>()

    init {

    }

    fun getMusicData(term: String){
        viewModelScope.launch {
            val getResponse = remoteRepo.getMusicData(term)
            musicApiResponse.value = getResponse
        }
    }
}