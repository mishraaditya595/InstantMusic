package xyz.theadityamishra.musictunes.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.theadityamishra.musictunes.R
import xyz.theadityamishra.musictunes.databinding.SearchFragmentBinding
import xyz.theadityamishra.musictunes.model.remote.RemoteRepo
import xyz.theadityamishra.musictunes.ui.adapters.SearchAdapter
import xyz.theadityamishra.musictunes.viewModel.ViewModel
import xyz.theadityamishra.musictunes.viewModel.ViewModelFactory

class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding
    private lateinit var viewModel: ViewModel
    private lateinit var searchAdapter: SearchAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.search_fragment, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SearchFragmentBinding.bind(view)

        val remoteRepo = RemoteRepo()
        val viewModelFactory = ViewModelFactory(requireContext(), remoteRepo)
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModel::class.java]

        binding.searchBtn.setOnClickListener {
            val term = binding.searchBarEt.text.toString()

            viewModel.getMusicData(term)

            viewModel.musicApiResponse.observe(viewLifecycleOwner, Observer {
                val searchResponseList = it.results
                searchAdapter.submitList(it.results)
            })
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.searchRecyclerView.apply {
            searchAdapter = SearchAdapter()
            adapter = searchAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
        }
    }
}