package com.example.banktransactions.retrofit

import com.example.banktransactions.dataclass.Transactons
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface getData {

    @GET("/all")
    fun getTransactionList(): Call<List<Transactons>>

    @POST("/new")
    fun createTransaction(@Body transactons: Transactons): Call<Transactons>
}