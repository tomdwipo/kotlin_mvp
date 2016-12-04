package com.tommyputranto.kotlin_mvp.manager

import com.google.gson.GsonBuilder
import com.tommyputranto.kotlin_mvp.api.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by gits on 12/4/16.
 */
object ApiManager {
    private const val SERVER: String = "http://entry.sandbox.gits.id/apicafe/"


    private lateinit var mApiService: ApiService

    init {
        val retrofit = initRetrofit()
        initServices(retrofit)
    }

    private fun initRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            })
            addInterceptor(interceptor)
        }

        return Retrofit.Builder().baseUrl(SERVER)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(createGsonConverter())
                .client(client.build())
                .build()
    }

    private fun createGsonConverter(): GsonConverterFactory {
        val builder = GsonBuilder().serializeNulls()
        return GsonConverterFactory.create(builder.create())
    }

    private fun initServices(retrofit: Retrofit) {
        mApiService = retrofit.create(ApiService::class.java)
    }


    fun loadList() =
            mApiService.getList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())!!

}