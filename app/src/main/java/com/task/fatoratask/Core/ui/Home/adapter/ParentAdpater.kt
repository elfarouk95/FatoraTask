package com.task.fatoratask.Core.ui.Home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class ParentAdpater<Holder : RecyclerView.ViewHolder?, M> :
    RecyclerView.Adapter<Holder>() {
    var arrayList: ArrayList<M>? = ArrayList()
        set(value) {
            value?.let { field?.addAll(it) }
            notifyDataSetChanged()
        }

    fun clearItem() {
        arrayList!!.clear()
        notifyDataSetChanged()
    }

    var mContext: Context? = null
    private val _layout = 0
    var viewHolder: Holder? = null
    abstract fun get_layout(): Int
    abstract fun getViewHolder(v: View?): Holder


    fun getItem(pos: Int): M {
        return arrayList!![pos]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        mContext = parent.context
        val v = LayoutInflater.from(mContext).inflate(get_layout(), parent, false)
        return getViewHolder(v)
    }

    override fun getItemCount(): Int {
        return if (arrayList == null) 0 else arrayList!!.size
    }
}