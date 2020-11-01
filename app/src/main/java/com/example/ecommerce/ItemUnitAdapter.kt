package com.example.ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.data.model.Product


class ItemUnitAdapter(private val products : ArrayList<Product>) :RecyclerView.Adapter<ItemUnitAdapter.ItemViewHolder>() {

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
       // Picasso.get().load(products[position].image).into(holder.image)
        //holder.title.text = products[position].title

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent,false)
        return  ItemViewHolder(view)
    }

    override fun getItemCount() = products.size




    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        //val image : ImageView = itemView.findViewById(R.id.photo)
        //val title : TextView = itemView.findViewById(R.id.tittle)
    }
}


//(
// LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
//)