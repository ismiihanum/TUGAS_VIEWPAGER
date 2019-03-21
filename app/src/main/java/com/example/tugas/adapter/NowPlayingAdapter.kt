package com.example.tugas.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.tugas.R
import com.example.tugas.model.ResultsItem
import kotlinx.android.synthetic.main.list_item.view.*

class NowPlayingAdapter: RecyclerView.Adapter<NowPlayingAdapter.ViewHolder> {

    private lateinit var context: Context
    private var ResultsItem: ArrayList<ResultsItem>? = null
    private var orig: ArrayList<ResultsItem>? = null
//    private var recycleFilter: RecycleFilter? = null

    constructor(context: Context?, ResultsItem: ArrayList<ResultsItem>) : this() {
        this.context = context!!
        this.ResultsItem = ResultsItem
        this.orig = ResultsItem
    }

    override fun getItemCount(): Int {
        return ResultsItem?.size as Int
    }

    constructor()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tanggal.text = ResultsItem?.get(position)?.title
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500" + ResultsItem?.get(position)?.posterPath)
            .override(512, 512)
            .error(R.drawable.abc)
            .into(holder.ivMoview)
        holder.btnDetail.setOnClickListener {
            Toast.makeText(context, "Update Project UAS", Toast.LENGTH_LONG).show()
        }

        holder.btnShare.setOnClickListener {
            Toast.makeText(context, "Update Project UAS", Toast.LENGTH_LONG).show()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tanggal = view.tvTittle
        val ivMoview = view.ivMovie
        val btnDetail: Button = view.btnDetail
        val btnShare: Button = view.btnShare
    }


}