package com.tommyputranto.kotlin_mvp.MVP.Home

import android.os.Bundle
import com.tommyputranto.kotlin_mvp.MVP.Base.BaseMvpActivity
import com.tommyputranto.kotlin_mvp.R
import kotlinx.android.synthetic.main.home_activity.*

/**
 * Created by gits on 12/1/16.
 */
class HomeActivity  : BaseMvpActivity<HomeContract.View,
        HomeContract.Presenter>(),
        HomeContract.View {
    override var mPresenter: HomeContract.Presenter = HomePresenter()

    override fun showText(text: String) {
        text_test.setText(text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        mPresenter.loadText()
    }
}