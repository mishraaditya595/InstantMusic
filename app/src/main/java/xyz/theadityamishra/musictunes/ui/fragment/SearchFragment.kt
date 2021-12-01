package xyz.theadityamishra.musictunes.ui.fragment

import xyz.theadityamishra.musictunes.model.old.SearchData
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import xyz.theadityamishra.musictunes.ui.Adapter.SearchRecyclerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import xyz.theadityamishra.musictunes.R
import java.util.ArrayList

class SearchFragment : Fragment() {

    var searchDataList: MutableList<SearchData>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

//        searchDataList?.add(SearchData("Pop", R.drawable.pop))
//        searchDataList?.add(SearchData("Hip Hop", R.drawable.eminem))
//        searchDataList?.add(SearchData("Rock music", R.drawable.pitbull))
//        searchDataList?.add(SearchData("Romantic", R.drawable.selena_tw))
//        searchDataList?.add(SearchData("Podcasts", R.drawable.gladiator))
//        searchDataList?.add(SearchData("Motivation", R.drawable.motivation))
//        searchDataList?.add(SearchData("New Release", R.drawable.ariana))
//        searchDataList?.add(SearchData("Acoustic", R.drawable.enrique_r))
//        searchDataList?.add(SearchData("Discover", R.drawable.last_archive))
//        searchDataList?.add(SearchData("Concerts", R.drawable.dance))
//        searchDataList?.add(SearchData("Bollywood", R.drawable.kk))
//        searchDataList?.add(SearchData("Soothing", R.drawable.arijit))

        val v = inflater.inflate(R.layout.search_fragment, container, false)
//        val recyclerView: RecyclerView = v.findViewById(R.id.searchRecycler)
//        val searchRecyclerAdapter = SearchRecyclerAdapter(activity, searchDataList)
//        recyclerView.layoutManager = GridLayoutManager(activity, 2)
//        recyclerView.adapter = searchRecyclerAdapter
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}