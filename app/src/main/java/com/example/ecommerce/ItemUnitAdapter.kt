package com.example.ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemUnitAdapter :RecyclerView.Adapter<ItemUnitAdapter.ItemViewHolder>(){


    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
    )
    override fun getItemCount()=5

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }




}