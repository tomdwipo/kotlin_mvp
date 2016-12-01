package com.tommyputranto.kotlin_mvp.MVP.Home

import com.tommyputranto.kotlin_mvp.MVP.Base.BaseMvpPresenterImpl

/**
 * Created by gits on 12/1/16.
 */
class HomePresenter : BaseMvpPresenterImpl<HomeContract.View>(),
HomeContract.Presenter  {
    override fun loadText() {
        mView?.showText("tes123145")
    }
}