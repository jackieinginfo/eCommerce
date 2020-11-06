package com.example.ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.data.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer


class MyQuoteAdapter(private val products: ArrayList<Product>) :
    RecyclerView.Adapter<MyQuoteAdapter.ViewHolder>()


{
    private var items = listOf<Product>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyQuoteAdapter.ViewHolder, position: Int) {
        val item = items[position]
        Picasso.get().load(products[position].image).into(holder.image)
        // holder.image.rootView =item.image
        holder.title.text = item.title
        holder.price.text = item.price.toString()
    }

    fun replaceItems(items: List<Product>) {
        this.items = items
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = items.size


    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        val image: ImageView = itemView.findViewById(R.id.contentTextView)
        val title: TextView = itemView.findViewById(R.id.sourceTextView)
        val price: TextView = itemView.findViewById(R.id.price)

    }

}


//private var lbEvent :TextView = itemView.findViewById(R.id.sourceTextView)

/**
 * This function will get called once for each item in the collection thaat we want to show  in our recycler view
 * Paint a single raw of the recycler view with this Product data class
 */
/*    fun UpdateEvent(event: Event){

        lbEvent.text = event.toString()
        if(event.localPhotoUri != null && event.photo != "null"){
            ImageDecoder.createSource(activity!!.conteResolver, uri.parse)
            val bitmap = ImageDecoder.decodeBitmap(source)
            image.setImageBitmap(bitmap)

        }
    }


    private fun clearAll(

    ){.setText("")
        .}   */










