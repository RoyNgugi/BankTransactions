package com.example.banktransactions.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitClientInstance {

    companion object {
        private var retrofit: Retrofit? = null
        private val BASE_URL = "http://192.168.1.38:8080/transfer/"
        val retrofitInstance: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit

            }
    }
}