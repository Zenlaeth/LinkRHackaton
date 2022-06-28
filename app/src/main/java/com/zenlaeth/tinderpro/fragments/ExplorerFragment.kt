package com.zenlaeth.tinderpro.fragments

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.tinderpro.*
import com.zenlaeth.tinderpro.adapter.ExplorerAdapter
import android.view.MenuInflater

class ExplorerFragment(private val context: HomeActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater?.inflate(R.layout.explorer_categories, container, false)
        setHasOptionsMenu(true);

        // recuperer recycler view
        val explorerRecyclerView = view.findViewById<RecyclerView>(R.id.explorerRV)
        explorerRecyclerView.adapter = ExplorerAdapter(object : ExplorerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 0) {
                    requireActivity().run{
                        startActivity(Intent(this, ExplorerResultActivity::class.java))
                    }
                }
                if (position == 1) {
                    requireActivity().run{
                        startActivity(Intent(this, ExplorerResultActivity::class.java))
                    }
                }
                if (position == 2) {
                    requireActivity().run{
                        startActivity(Intent(this, ExplorerResultActivity::class.java))
                    }
                }
                if (position == 3) {
                    requireActivity().run{
                        startActivity(Intent(this, ExplorerResultActivity::class.java))
                    }
                }
            }
        })
        explorerRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}

/*
class ExplorerFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        return inflater?.inflate(R.layout.explorer, container, false)
    }
}*/
