package com.tommyputranto.kotlin_mvp.extension

import android.content.Context
import android.content.res.Resources
import android.support.annotation.StringRes
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tommyputranto.kotlin_mvp.R
import java.lang.ref.WeakReference

/**
 * Created by gits on 12/4/16.
 */
inline fun <reified T> Gson.fromJson(json: String): T {
    return this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}
inline fun textError(text: String?,context:Context): Int {
    var textLast : Int
    if (text.equals(context.getString(R.string.internet_connection_unavailable))){
        textLast = R.string.internet_connection_unavailable
    }else{
       textLast = R.string.internet_connection_check
    }
    return textLast
}