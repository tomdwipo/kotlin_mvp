package com.tommyputranto.kotlin_mvp.MVP.Base

import android.content.Context


/**
 * Created by gits on 12/1/16.
 */
interface BaseMvpView {

    fun getContext() : Context

    fun showError(error : String?)

    fun showMessage(message: String)
}