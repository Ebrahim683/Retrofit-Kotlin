package com.example.retrofitkotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var list: List<DataModel>
    lateinit var recAdapter: RecAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recID.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        loadData()
    }

    private fun loadData() {
        val call: Call<List<DataModel>> = ApiController.getInstants.getData()
        call.enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>?,
                response: Response<List<DataModel>>?
            ) {
                if (response!!.isSuccessful) {
                    progressBarID.visibility = View.GONE
                    list = response.body() as List<DataModel>
                    recAdapter = RecAdapter(this@MainActivity, list)
                    recID.adapter = recAdapter
                } else {
                    Log.e("error1", "Error = " + response.message())
                }
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                Log.e("error2", "Error = " + t!!.message)
            }
        })
    }

}

