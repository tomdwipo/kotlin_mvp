package com.tommyputranto.kotlin_mvp.MVP.Home

import com.tommyputranto.kotlin_mvp.MVP.Base.BaseMvpPresenter
import com.tommyputranto.kotlin_mvp.MVP.Base.BaseMvpView

/**
 * Created by gits on 12/1/16.
 */
object HomeContract {

    interface View : BaseMvpView {
        fun showText(text:String)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadText()
    }
}