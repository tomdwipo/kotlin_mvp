package com.tommyputranto.kotlin_mvp.mvp.home

import android.support.annotation.StringRes
import com.tommyputranto.kotlin_mvp.mvp.base.BaseMvpPresenter
import com.tommyputranto.kotlin_mvp.mvp.base.BaseMvpView
import com.tommyputranto.kotlin_mvp.api.dao.list.ListDao

/**
 * Created by gits on 12/1/16.
 */
object HomeContract {

    interface View : BaseMvpView {
        fun showList(list: ListDao)
        fun showErrorMessage(text: String?)
    }
    interface Presenter : BaseMvpPresenter<View> {
        fun loadList()
    }
}