package com.tommyputranto.kotlin_mvp.MVP.Base

import com.tommyputranto.kotlin_mvp.MVP.Base.BaseMvpView

/**
 * Created by gits on 12/1/16.
 */
interface BaseMvpPresenter<in V : BaseMvpView> {
    fun attachView(view: V)

    fun detachView()
}