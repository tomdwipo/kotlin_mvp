package com.tommyputranto.kotlin_mvp.MVP.api

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.tommyputranto.kotlin_mvp.MVP.extension.fromJson
import retrofit2.Response
import java.io.IOException

/**
 * Created by gits on 12/4/16.
 */
data class ErrorBody(val code: Int, @SerializedName("error") val message: String) {
    override fun toString(): String {
        return "{code:$code, message:\"$message\"}"
    }

    companion object {
        val UNKNOWN_ERROR = 0

        private val GSON = Gson()

        fun parseError(response: Response<*>?): ErrorBody? {
            return (response?.errorBody())?.let {
                try {
                    GSON.fromJson(it.string())
                } catch (ignored: IOException) {
                    null
                }
            }
        }
    }
}
