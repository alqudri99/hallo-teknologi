package com.alqudri.hallotechnology.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.hallotechnology.R
import com.alqudri.hallotechnology.model.office.DataItem
import kotlinx.android.synthetic.main.content_office.view.*

class OfficeAdapter (var data: List<DataItem>): RecyclerView.Adapter<OfficeAdapter.ViewHolder>(){
    inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(dat: DataItem){
            view.kantor.text = dat.province +" - "+dat.name +" ("+dat.noHp+")"+dat.address
            if(position == data.size-1 && position != 0){
                view.div.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_office, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(data.get(position))
    }

}