package com.tommyputranto.kotlin_mvp.model.list

import com.google.gson.annotations.SerializedName

/**
 * Created by gits on 12/4/16.
 */
data class ListDao(@SerializedName("DATA") val data: List<Data>)