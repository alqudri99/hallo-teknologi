package com.alqudri.hallotechnology.ui.office

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alqudri.hallotechnology.R
import com.alqudri.hallotechnology.adapter.OfficeAdapter
import com.alqudri.hallotechnology.model.office.DataItem
import com.alqudri.hallotechnology.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_office.*

class OfficeFragment : Fragment() {
    lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_office, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)

        homeViewModel.getOffice()

        homeViewModel.listOffice.observe(viewLifecycleOwner, Observer {
            office.layoutManager = LinearLayoutManager(context)
            office.adapter = OfficeAdapter(it.data as List<DataItem>)
        })
    }
}