package com.tommyputranto.kotlin_mvp.mvp.home

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.tommyputranto.kotlin_mvp.mvp.base.BaseMvpActivity
import com.tommyputranto.kotlin_mvp.api.dao.list.Data
import com.tommyputranto.kotlin_mvp.api.dao.list.ListDao
import com.tommyputranto.kotlin_mvp.R
import com.tommyputranto.kotlin_mvp.extension.textError
import kotlinx.android.synthetic.main.home_activity.*
import java.util.*

/**
 * Created by gits on 12/1/16.
 */
class HomeActivity  : BaseMvpActivity<HomeContract.View,
        HomeContract.Presenter>(),
        HomeContract.View {

    private var mAdapter: HomeAdapter? = null
    override var mPresenter: HomeContract.Presenter = HomePresenter()
    override fun showList(list: ListDao) {
        mAdapter?.addRepositories(list.data)
        mAdapter?.notifyDataSetChanged()
        hideProgress()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        setUpRecyclerView()
        mPresenter.loadList()
        showProgress()
    }
    private fun setUpRecyclerView() {
        mAdapter = HomeAdapter(ArrayList<Data>(), {
            Log.e("testt", it.id)
          //  startActivity(RepositoryDetailActivity.newIntent(this, it.name))
        })
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = mAdapter
    }
    private fun showProgress() {
        recyclerview.visibility = View.GONE
        pageloader.startProgress()
    }

    private fun hideProgress() {
        recyclerview.visibility = View.VISIBLE
        pageloader.stopProgress()
    }
    private fun stopProggress(){
        recyclerview.visibility = View.GONE
        pageloader.stopProgressAndFailed()
    }
    override fun showErrorMessage(text: String?) {
        textError(text, this)
        stopProggress()
    }

}