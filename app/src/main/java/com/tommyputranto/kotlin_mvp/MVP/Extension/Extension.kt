package com.tommyputranto.kotlin_mvp.MVP.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by gits on 12/4/16.
 */
inline fun <reified T> Gson.fromJson(json: String): T {
    return this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}