package com.zenlaeth.tinderpro.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.tinderpro.CvRepository.Singleton.cvList
import com.zenlaeth.tinderpro.HomeActivity
import com.zenlaeth.tinderpro.R
import com.zenlaeth.tinderpro.adapter.CvAdapter
import com.zenlaeth.tinderpro.adapter.CvItemDecoration

class HomeFragment(private val context: HomeActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater?.inflate(R.layout.fragment_home, container, false)

        // recuperer le RecycleView
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = CvAdapter(context, cvList, R.layout.cv_item_horizontal)

        // recuperer le second RecycleView
//        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
//        verticalRecyclerView.adapter = CvAdapter(context ,cvList, R.layout.cv_item_vertical)
//        verticalRecyclerView.addItemDecoration(CvItemDecoration())

        return view
    }

}