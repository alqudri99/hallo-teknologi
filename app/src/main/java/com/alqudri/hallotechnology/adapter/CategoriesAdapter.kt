package com.alqudri.hallotechnology.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.hallotechnology.R
import com.alqudri.hallotechnology.model.category.DataItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content_categories.view.*

class CategoriesAdapter(var onItemClick: OnItemClick, var position: Int, var data: List<DataItem>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>(){
    inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(dat: DataItem){

            if (this@CategoriesAdapter.position == position && this@CategoriesAdapter.position != 1000){
                view.contentClick.setBackgroundResource(R.drawable.rounded_back)
                view.tv_cat.setTextColor(Color.parseColor("#FFFFFF"))
            }
            Glide.with(view).load(dat.icon).into(view.icon_category)
            view.tv_cat.text = dat.categoryName
            view.contentClick.setOnClickListener {
                onItemClick.onClick(position, ""+dat.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_categories, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(data[position])
    }

    interface OnItemClick{
        fun onClick(position: Int, id: String)
    }

}