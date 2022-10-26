package com.xll.e_commerceapp.ui.Activity.xml.adpter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xll.e_commerceapp.R

class HomeAdpter(var context: Context)  : RecyclerView.Adapter<HomeAdpter.ViewHoler>(){


    inner class ViewHoler(view: View) : RecyclerView.ViewHolder(view) {

//        var name = view.findViewById<TextView>(R.id.name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
