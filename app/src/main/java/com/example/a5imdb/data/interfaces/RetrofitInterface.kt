package com.example.a5imdb.data.interfaces
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitInterface {
    companion object {
        fun buildRetrofitObj(
            baseUrl : String
        ): Retrofit {
            return Retrofit.Builder()
                //.baseUrl("https://api.themoviedb.org/3/")
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
