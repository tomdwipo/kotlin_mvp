package com.tommyputranto.kotlin_mvp.mvp.base

import com.tommyputranto.kotlin_mvp.mvp.base.BaseMvpPresenter
import com.tommyputranto.kotlin_mvp.mvp.base.BaseMvpView

/**
 * Created by gits on 12/1/16.
 */
open class BaseMvpPresenterImpl<V : BaseMvpView> : BaseMvpPresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}