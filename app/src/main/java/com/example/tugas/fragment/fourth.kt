package com.example.tugas.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tugas.R
import com.example.tugas.adapter.NowPlayingAdapter
import com.example.tugas.interactor.ApiClient
import com.example.tugas.interactor.ApiService
import com.example.tugas.model.ResultsItem
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * A simple [Fragment] subclass.
 *
 */
@Suppress("UNCHECKED_CAST")
class fourth : Fragment() {

    var items: ArrayList<ResultsItem> = arrayListOf()
    lateinit var nowPlayingAdapter: NowPlayingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_fourth, container, false)


        val recyclerView: RecyclerView = view.findViewById(R.id.rvList)

        val hantuHanum: ApiService = ApiClient.CallHanumHAHAHHA()
        hantuHanum.getNowPlaying()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.results as ArrayList<ResultsItem>
                nowPlayingAdapter = NowPlayingAdapter(activity, items)
                recyclerView.adapter = nowPlayingAdapter
                recyclerView.layoutManager = LinearLayoutManager(activity)
                nowPlayingAdapter.notifyDataSetChanged()



            })




        return view
    }


}
