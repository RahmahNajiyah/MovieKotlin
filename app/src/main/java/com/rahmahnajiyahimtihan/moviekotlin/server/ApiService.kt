package com.rahmahnajiyahimtihan.moviekotlin.server

import com.rahmahnajiyahimtihan.moviekotlin.response.ResponseMovie
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("movie/550?api_key=61a732264fa2977939306018c139391c")
    fun ambilDataMovie():Call<ResponseMovie>
}