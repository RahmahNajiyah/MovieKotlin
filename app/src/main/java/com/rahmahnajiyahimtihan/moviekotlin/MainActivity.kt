package com.rahmahnajiyahimtihan.moviekotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.rahmahnajiyahimtihan.moviekotlin.response.ResponseMovie
import com.rahmahnajiyahimtihan.moviekotlin.server.ConfigRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get configuration
        val config = ConfigRetrofit().service

        //get request
        val request = config.ambilDataMovie()

        //get response dan eksekusi
        request.enqueue(object : Callback<ResponseMovie>{
            override fun onFailure(call: Call<ResponseMovie>?, t: Throwable?) {

                Log.d("error server", t?.message)
            }

            override fun onResponse(call: Call<ResponseMovie>?, response: Response<ResponseMovie>?) {
               //get response json
                val dataJson = response?.body()?.production_companies

                Log.d("response server", dataJson.toString())
                Toast.makeText(this@MainActivity, dataJson.toString(), Toast.LENGTH_LONG).show()

            }
        })
    }
}
