package com.alqudri.hallotechnology.ui.home

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.alqudri.hallotechnology.R
import com.alqudri.hallotechnology.adapter.CategoriesAdapter
import com.alqudri.hallotechnology.adapter.ItemAdapter
import com.alqudri.hallotechnology.adapter.MerekAdapter
import com.alqudri.hallotechnology.model.category.DataItem
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    var state = true;
    var state2 = true;
    var ids = "0"
    var idMerek = "0"
    lateinit var onItemClick: CategoriesAdapter.OnItemClick
    lateinit var onItemClick2: MerekAdapter.OnItemClick
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var homeViewModel: HomeViewModel
    var list: List<DataItem> = ArrayList<DataItem>()
    var list1: List<com.alqudri.hallotechnology.model.DataItem> = ArrayList<com.alqudri.hallotechnology.model.DataItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)
        onItemClick = object : CategoriesAdapter.OnItemClick{
            override fun onClick(position: Int, id: String) {
                ids = id
                homeViewModel.getHome(find.text.toString(), id, idMerek)
                trigger(rv, position)
            }
        }

        onItemClick2 = object : MerekAdapter.OnItemClick{
            override fun onClick(position: Int, id: String) {
                idMerek = id
                homeViewModel.getHome(find.text.toString(), ids, id)
                trigger2(rv_merek, position)
            }
        }
//        context?.hideKeyboard(find)
//        activity?.getWindow()?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        activity?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        )

        find.setOnEditorActionListener(object : TextView.OnEditorActionListener{
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                if(p1 == EditorInfo.IME_ACTION_SEARCH){
                    find.clearFocus()
                    val inn = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inn.hideSoftInputFromWindow(find.windowToken, 0)
                    return true
                }
                return false
            }

        })
        find.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                homeViewModel.getHome(find.text.toString(), ids, idMerek)
            }

        })
        homeViewModel.getCategory()
        homeViewModel.getHome()
        homeViewModel.getMerek()

        toggle.setOnClickListener {
            if (state){
                Log.d("haha", "ajajfa")
                upArrow.visibility = View.VISIBLE
                down.visibility = View.GONE
                rv.visibility = View.VISIBLE
                state = false
            }else{
                state = true
                Log.d("haha", "ajaja")
                down.visibility = View.VISIBLE
                upArrow.visibility = View.GONE
                rv.visibility = View.GONE
            }
        }

        toggle_merek.setOnClickListener {
            if (state2){
                Log.d("haha", "ajajfa")
                upArrow_merek.visibility = View.VISIBLE
                down_merek.visibility = View.GONE
                rv_merek.visibility = View.VISIBLE
                state2 = false
            }else{
                state2 = true
                Log.d("haha", "ajaja")
                down_merek.visibility = View.VISIBLE
                upArrow_merek.visibility = View.GONE
                rv_merek.visibility = View.GONE
            }
        }

        with(homeViewModel){
            listCategory.observe(viewLifecycleOwner, Observer {
                list = it.data as List<DataItem>
                rv.adapter = CategoriesAdapter(onItemClick, 1000, it.data as List<DataItem>)

            })

            listHome.observe(viewLifecycleOwner, Observer {
                rvr.adapter = ItemAdapter(it.data as List<com.alqudri.hallotechnology.model.home.DataItem>)
            })

            listMerek.observe(viewLifecycleOwner, Observer {
                list1 = it.data as List<com.alqudri.hallotechnology.model.DataItem>
                rv_merek.adapter = MerekAdapter(onItemClick2, 1000, it.data as List<com.alqudri.hallotechnology.model.DataItem>)
            })
        }
    }
    fun trigger(rv: RecyclerView, position: Int){
        rv.adapter = CategoriesAdapter(onItemClick, position, list)
    }
    fun trigger2(rv: RecyclerView, position: Int){
        rv_merek.adapter = MerekAdapter(onItemClick2, position, list1)
    }

}