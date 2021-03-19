package com.alqudri.hallotechnology.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alqudri.hallotechnology.HomeActivity
import com.alqudri.hallotechnology.R
import com.alqudri.hallotechnology.adapter.ProductSliderAdapter
import com.alqudri.hallotechnology.ui.home.HomeViewModel
import com.alqudri.hallotechnology.utill.getRupiah
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_item.view.*


class DetailActivity : AppCompatActivity() {
    lateinit var homeViewModel:HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("id", 0)
        homeViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            HomeViewModel::class.java)

        homeViewModel.getDetail(""+id)
        back.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        with(homeViewModel){
            listDetail.observe(this@DetailActivity, Observer {
                lin.visibility = View.VISIBLE
                prog.visibility = View.GONE
                imageSlider.setSliderAdapter(ProductSliderAdapter(it.data?.foto as List<String>))
                imageSlider.pagerIndicator.visibility= View.VISIBLE
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    deskripsi.setText(Html.fromHtml(it.data.description, Html.FROM_HTML_MODE_COMPACT));
                } else {
                    deskripsi.setText(Html.fromHtml(it.data.description));
                }

                title_detail.text = it.data.productName

                link.setOnClickListener {it2 ->
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(it?.data.link))
                    startActivity(browserIntent)
                }
                link.text = it.data.link
                var st = it?.data.price?.toBigInteger()?.let { it1 -> getRupiah(it1) }?.replace("Rp", "Rp ")

                price_detail.text = st?.replace("IDR", "IDR ")
                stock.text = "Stock : "+it?.data?.stock
            })
        }
    }
}