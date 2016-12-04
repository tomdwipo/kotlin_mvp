package com.tommyputranto.kotlin_mvp.api.dao.list

import com.google.gson.annotations.SerializedName

/**
 * Created by gits on 12/4/16.
 */
data class ListDao(@SerializedName("DATA") val data: List<Data>)

data class Data (val id: String, val nama: String, val alamat: String, val url_foto: String)