package com.tommyputranto.kotlin_mvp.mvp.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tommyputranto.kotlin_mvp.R


/**
 * Created by gits on 12/4/16.
 */
abstract class BaseMvpFragment<in V : BaseMvpView, T : BaseMvpPresenter<V>>
    : Fragment(), BaseMvpView {
    override fun getContext(): Context = activity.applicationContext

    protected abstract var mPresenter: T

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        //return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.attachView(activity.applicationContext as V)
    }

}