package com.tommyputranto.kotlin_mvp.mvp.base

import com.tommyputranto.kotlin_mvp.mvp.base.BaseMvpView

/**
 * Created by gits on 12/1/16.
 */
interface BaseMvpPresenter<in V : BaseMvpView> {
    fun attachView(view: V)
    fun detachView()

}