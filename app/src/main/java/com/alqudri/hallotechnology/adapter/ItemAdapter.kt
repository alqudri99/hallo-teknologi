package com.alqudri.hallotechnology.adapter

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.hallotechnology.ui.detail.DetailActivity
import com.alqudri.hallotechnology.R
import com.alqudri.hallotechnology.model.home.DataItem
import com.alqudri.hallotechnology.utill.getRupiah
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content_item.view.*

class ItemAdapter (var data: List<DataItem>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    inner class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: DataItem){
            view.item_content.setOnClickListener {
                val intent = Intent(view.context, DetailActivity::class.java)
                intent.putExtra("id", data.id)
                view.context.startActivity(intent)
            }
            Glide.with(view).load(data.url).placeholder(R.drawable.placholder).into(view.img_content)
            var st =  ""+ data.price?.toBigInteger()?.let { getRupiah(it) }?.replace("Rp", "Rp ")
            view.price.text =st.replace("IDR", "IDR ")
            view.title_content.text = data.productName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.content_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(data.get(position))
    }

}