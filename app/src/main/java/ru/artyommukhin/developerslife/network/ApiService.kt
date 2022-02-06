package ru.artyommukhin.developerslife.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.artyommukhin.developerslife.data.model.Post
import ru.artyommukhin.developerslife.network.model.ApiListResponse

interface ApiService {

    @GET("latest/{page}")
    suspend fun getLatestGifs(
        @Path("page") page: Int,
        @Query("json") isJson: Boolean = true
    ) : ApiListResponse

    @GET("top/{page}")
    suspend fun getTopGifs(
        @Path("page") page: Int,
        @Query("json") isJson: Boolean = true
    ) : ApiListResponse

    @GET("hot/{page}")
    suspend fun getHotGifs(
        @Path("page") page: Int,
        @Query("json") isJson: Boolean = true
    ) : ApiListResponse

    @GET("random")
    suspend fun getRandomGif(
        @Query("json") isJson: Boolean = true
    ) : Post

}

//private object NetworkInterceptor : Interceptor {
////    override fun intercept(chain: Interceptor.Chain): Response {
////
////    }
//}


private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
//    .addInterceptor(NetworkInterceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl("http://developerslife.ru/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()


object Api {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
