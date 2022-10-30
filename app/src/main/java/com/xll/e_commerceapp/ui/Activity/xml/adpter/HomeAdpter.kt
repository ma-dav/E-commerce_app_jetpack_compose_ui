package com.xll.e_commerceapp.ui.Activity.xml.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.get
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xll.e_commerceapp.Data.repository.HomeRepoItem
import com.xll.e_commerceapp.R

class HomeAdpter(var context: Context)  : RecyclerView.Adapter<HomeAdpter.ViewHoler>(){
    var list = ArrayList<HomeRepoItem>()

    inner class ViewHoler(view: View) : RecyclerView.ViewHolder(view) {
        var Image = view.findViewById<ImageView>(R.id.Image)
        var heart = view.findViewById<ImageView>(R.id.heart)
        var price = view.findViewById<TextView>(R.id.price)
        var title = view.findViewById<TextView>(R.id.title)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        return ViewHoler(
            LayoutInflater.from(parent.context).inflate(R.layout.itemhome, parent, false)
        )
    }
    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        val listPosition = list[position]
        Picasso.get().load(listPosition.Image).centerCrop().fit().into(holder.Image)
        if (listPosition.heart) Picasso.get().load(R.drawable.heart).into(holder.heart) else Picasso.get().load(R.drawable.heartblek).into(holder.heart)
        holder.title.text = listPosition.title
        holder.price.text = listPosition.price
        holder.heart.setOnClickListener {
             listPosition.heart = !listPosition.heart
             notifyDataSetChanged()
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
    fun Get_Date(date: ArrayList<HomeRepoItem>) {
        this.list = date
        notifyDataSetChanged()
    }
}
