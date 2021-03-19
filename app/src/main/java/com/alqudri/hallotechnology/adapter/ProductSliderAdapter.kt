package com.alqudri.hallotechnology.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.hallotechnology.R
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.content_slider.view.*

class ProductSliderAdapter(var data: List<String>) : SliderViewAdapter<ProductSliderAdapter.ViewHolder>(){
    class ViewHolder(var view: View): SliderViewAdapter.ViewHolder(view) {
        fun bind(dat: String){
            Glide.with(view).load(dat).into(view.product_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.content_slider, parent, false)
        return  ViewHolder(view)
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        return viewHolder!!.bind(data[position])
    }

}
