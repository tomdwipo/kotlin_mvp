package com.tommyputranto.kotlin_mvp.MVP.Base

import com.tommyputranto.kotlin_mvp.MVP.Base.BaseMvpPresenter
import com.tommyputranto.kotlin_mvp.MVP.Base.BaseMvpView

/**
 * Created by gits on 12/1/16.
 */
open class BaseMvpPresenterImpl <V : BaseMvpView> : BaseMvpPresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}