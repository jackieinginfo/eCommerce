package com.example.ecommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.data.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_blue.*

class blueFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() =
            blueFragment().apply {
                arguments = Bundle().apply {
                    //putInt(this@Companion.toString(), 2)
                }
            }
    }

    private lateinit var adapter: MyQuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            // columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blue, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val products = arrayListOf<Product>(        )
        for (i in 0..100){

            products.add(Product("cake rosa","https://via.placeholder.com/300.png/09f/fff",20.00))
        }

        adapter = MyQuoteAdapter(products)
        adapter.replaceItems(products)

        list.adapter = adapter
    }
}
//(private val products : ArrayList<Product>)
    class MyQuoteAdapter(private val products: ArrayList<Product>) : RecyclerView.Adapter<MyQuoteAdapter.ViewHolder>() {
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
        }

        fun replaceItems(items: List<Product>) {
            this.items = items
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int = items.size




    class ViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val image : ImageView = itemView.findViewById(R.id.contentTextView)
        val title : TextView = itemView.findViewById(R.id.sourceTextView)

    }

}