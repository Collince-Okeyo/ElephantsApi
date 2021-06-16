package com.ramgdeveloper.elephantsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramgdeveloper.elephantsapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {
        ElephantsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        ElephantsApi.retrofitService.getElephants().enqueue(object : Callback<Elephants>{

            override fun onResponse(call: Call<Elephants>, response: Response<Elephants>) {
                Timber.d(response.body()?.get(3)?.name)

                adapter.submitList(response.body())
                binding.recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<Elephants>, t: Throwable) {
                Timber.d(t.localizedMessage)
            }

        })
    }
}