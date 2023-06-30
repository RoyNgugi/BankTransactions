package com.example.banktransactions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.banktransactions.databinding.ActivityMainBinding
import com.example.banktransactions.dataclass.Transactons
import com.example.banktransactions.retrofit.getData
import com.example.banktransactions.retrofit.retrofitClientInstance
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            if(binding.TargetAccount!=null && binding.editTextText2!=null && binding.editTextText3!=null ){
          val transactons = Transactons(
              binding.TargetAccount.toString(),
              binding.editTextText2.toString().toDoubleOrNull(),
              binding.editTextText3.toString(),
          null,
          ""
          )

                val transactsApi = retrofitClientInstance.retrofitInstance!!.create(getData::class.java)
                val call = transactsApi.createTransaction(transactons)

                call.enqueue(object : Callback<Transactons> {
                    override fun onResponse(
                        call: Call<Transactons>,
                        response: Response<Transactons>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@MainActivity, "API request Successfull", Toast.LENGTH_SHORT).show()
                            binding.TargetAccount.setText("")
                            binding.editTextText2.setText("")
                            binding.editTextText3.setText("")

                            val intent = Intent(this@MainActivity, TransactionList::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@MainActivity, "API request failed", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Transactons>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
            }


            }
        }