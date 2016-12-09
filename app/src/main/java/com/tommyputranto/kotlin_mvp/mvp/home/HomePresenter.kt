package com.tommyputranto.kotlin_mvp.mvp.home

import com.tommyputranto.kotlin_mvp.R
import com.tommyputranto.kotlin_mvp.api.core.GeneralErrorHandler
import com.tommyputranto.kotlin_mvp.mvp.base.BaseMvpPresenterImpl
import com.tommyputranto.kotlin_mvp.api.ApiManager
import com.tommyputranto.kotlin_mvp.extension.textError
import rx.functions.Action1

/**
 * Created by gits on 12/1/16.
 */
class HomePresenter : BaseMvpPresenterImpl<HomeContract.View>(),
HomeContract.Presenter  {
    override fun loadList() {
        ApiManager.loadList()
               .doOnError { mView?.showMessage(R.string.internet_connection_error) }
                .subscribe(Action1 { mView?.showList(it) },
                        GeneralErrorHandler(mView, true,
                                { throwable, errorBody, isNetwork -> mView?.showErrorMessage(throwable.message)}))

    }
}