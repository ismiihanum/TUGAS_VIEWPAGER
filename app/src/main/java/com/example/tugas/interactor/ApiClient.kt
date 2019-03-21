package com.example.tugas.interactor

import com.google.gson.GsonBuilder
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory

object ApiClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

    fun CallHanumHAHAHHA(): ApiService {
        val gsoon = GsonBuilder().create()

        return Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsoon))
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }
}
