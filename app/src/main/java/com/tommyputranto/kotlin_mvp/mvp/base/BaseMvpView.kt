package com.tommyputranto.kotlin_mvp.mvp.base

import android.content.Context
import android.support.annotation.StringRes


/**
 * Created by gits on 12/1/16.
 */
interface BaseMvpView {

    fun getContext(): Context

    fun showError(error: String?)

    fun showMessage(message: String)

    fun showError(@StringRes stringResId: Int)

    fun showMessage(@StringRes srtResId: Int)

}