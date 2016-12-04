package com.tommyputranto.kotlin_mvp.mvp.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.tommyputranto.kotlin_mvp.api.dao.list.Data
import com.tommyputranto.kotlin_mvp.api.dao.list.ListDao
import com.tommyputranto.kotlin_mvp.R
import kotlinx.android.synthetic.main.home_item.view.*

/**
 * Created by gits on 12/4/16.
 */
class HomeAdapter (private val list: MutableList<Data>,
                   val onClick: (Data) -> Unit)
    : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(list[position])
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent?.context)
                .inflate(R.layout.home_item, parent, false).let {
            ViewHolder(it, onClick)
        }
    }

    class ViewHolder(itemView: View, val onClick: (Data) -> Unit) : RecyclerView.ViewHolder(itemView){
        fun bindData(list: Data) {
            with(list) {
                Picasso.with(itemView.context).load(url_foto).into(itemView.imageItem)
                itemView.titleItem.text = nama
                itemView.addressItem.text = alamat
                itemView.setOnClickListener { onClick(this) }
            }
        }

       }
       fun addRepositories(newList: List<Data>) {
           list.addAll(newList)
       }
}