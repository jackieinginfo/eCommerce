package com.example.ecommerce.firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R
import com.example.ecommerce.data.model.DatabaseModel
import kotlinx.android.synthetic.main.fragment_not.view.*

class DataAdapter (var list : ArrayList<DatabaseModel>): RecyclerView.Adapter<DataAdapter.Viewholder> (){

    class Viewholder(itemView: View): RecyclerView.ViewHolder(itemView)
    {

        var name = itemView.tv_name
        var mail = itemView.tv_mail

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
            return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_not, parent,false))

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) { 

        holder.name.text = list[position].userName
        holder.mail.text = list[position].email
    }

    override fun getItemCount() =list.size
}