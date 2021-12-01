package xyz.theadityamishra.musictunes.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.theadityamishra.musictunes.model.remote.RemoteRepo

class ViewModelFactory(private val context: Context, private val remoteRepo: RemoteRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModel(context, remoteRepo) as T
    }

}