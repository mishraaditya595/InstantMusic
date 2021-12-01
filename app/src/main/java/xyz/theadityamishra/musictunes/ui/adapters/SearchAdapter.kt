package xyz.theadityamishra.musictunes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xyz.theadityamishra.musictunes.R
import xyz.theadityamishra.musictunes.databinding.SearchListItemBinding
import xyz.theadityamishra.musictunes.model.remote.iTunesModel

class SearchAdapter(): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    lateinit var binding: SearchListItemBinding

    inner class SearchViewHolder(binding: SearchListItemBinding): RecyclerView.ViewHolder(binding.root) {}

    val diffCallback = object : DiffUtil.ItemCallback<iTunesModel.Result>() {
        override fun areItemsTheSame(oldItem: iTunesModel.Result, newItem: iTunesModel.Result) =
            oldItem.artistId == newItem.artistId

        override fun areContentsTheSame(oldItem: iTunesModel.Result, newItem: iTunesModel.Result) =
            oldItem.hashCode() == newItem.hashCode()
    }

    val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<iTunesModel.Result>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        binding = SearchListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = differ.currentList[position]
        val songPreviewUrl = item.artworkUrl100
        Glide.with(binding.root)
            .load(songPreviewUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.songImg)
        binding.artistName.text = item.artistName
        binding.songName.text = item.trackName
    }

    override fun getItemCount() = differ.currentList.size


}