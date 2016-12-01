package com.tommyputranto.kotlin_mvp.MVP.Base

import android.content.Context
import android.support.annotation.StringRes

/**
 * Created by gits on 12/1/16.
 */
interface BaseMvpView {

    fun getContext() : Context

    fun showError(error : String?)

    fun showError(@StringRes stringResId: Int)

    fun showMessage(@StringRes srtResId: Int)

    fun showMessage(message: String)
}