package com.tommyputranto.kotlin_mvp.MVP.home

import com.tommyputranto.kotlin_mvp.MVP.base.BaseMvpPresenter
import com.tommyputranto.kotlin_mvp.MVP.base.BaseMvpView
import com.tommyputranto.kotlin_mvp.MVP.model.list.ListDao

/**
 * Created by gits on 12/1/16.
 */
object HomeContract {

    interface View : BaseMvpView {
        fun showList(list: ListDao)
    }
    interface Presenter : BaseMvpPresenter<View> {
        fun loadList()
    }
}