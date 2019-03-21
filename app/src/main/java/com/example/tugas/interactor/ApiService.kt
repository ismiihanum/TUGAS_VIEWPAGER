package com.example.tugas.interactor

import com.example.tugas.model.Items
import retrofit.http.GET
import rx.Observable

interface ApiService  {
    @GET("now_playing?api_key=22271f223b18bc9a76259fd43bc0d86d&language=en-US&page=1")
    fun getNowPlaying(): Observable<Items>
}