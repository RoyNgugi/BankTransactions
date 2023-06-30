package com.example.banktransactions

import android.os.Bundle
import android.os.PersistableBundle
import android.view.SurfaceControl.Transaction
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banktransactions.Adapter.Adapterclass
import com.example.banktransactions.databinding.ActivityMainBinding
import com.example.banktransactions.databinding.ActivityTransactionlistBinding
import com.example.banktransactions.dataclass.Transactons
import com.example.banktransactions.retrofit.getData
import com.example.banktransactions.retrofit.retrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var binding: ActivityTransactionlistBinding

class TransactionList: AppCompatActivity() {

 override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
  super.onCreate(savedInstanceState, persistentState)
  binding = ActivityTransactionlistBinding.inflate(layoutInflater)
  setContentView(binding.root)

  val transactsApi = retrofitClientInstance.retrofitInstance!!.create(getData::class.java)
  val call = transactsApi.getTransactionList()

  call.enqueue(object : Callback<List<Transactons>> {
   override fun onResponse(call: Call<List<Transactons>>, response: Response<List<Transactons>>) {
    if (response.isSuccessful) {
     val postsList = response.body()
     if (postsList != null) {
      val recyclerView = binding.rvView
      val transactonsAdapter = Adapterclass(postsList)
      recyclerView.adapter = transactonsAdapter
      recyclerView.layoutManager = LinearLayoutManager(this@TransactionList)
     }
    } else {
     Toast.makeText(this@TransactionList, "API request failed", Toast.LENGTH_SHORT).show()
    }
    }

   override fun onFailure(call: Call<List<Transactons>>, t: Throwable) {
    Toast.makeText(this@TransactionList, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
   }

  })

 }




}