package com.example.ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Itemunit2Adapter : RecyclerView.Adapter<Itemunit2Adapter.ItemViewHolder>()
{

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout2, parent, false)
        )

    override fun getItemCount()= 10


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {

    }




}


