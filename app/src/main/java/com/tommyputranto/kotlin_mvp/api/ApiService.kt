package com.tommyputranto.kotlin_mvp.api

import com.tommyputranto.kotlin_mvp.model.list.ListDao
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by gits on 12/4/16.
 */
interface ApiService {

    @GET(ApiSettings.LIST)
    fun getList(): Observable<ListDao>

}