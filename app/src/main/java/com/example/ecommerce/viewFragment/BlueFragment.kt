package com.example.ecommerce.viewFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.MyQuoteAdapter
import com.example.ecommerce.R
import com.example.ecommerce.data.model.Product
import kotlinx.android.synthetic.main.fragment_blue.*

class blueFragment : Fragment() {


        val products = arrayListOf<Product>(        )

        companion object {

            @JvmStatic
            fun newInstance() =
                blueFragment().apply {
                    arguments = Bundle().apply {

                        fun newInstance() = blueFragment()
                        //putInt(this@Companion.toString(), 2)
                    }
                }
        }

        fun loadView(view: View) {
            var recyclerView: RecyclerView = view.findViewById<RecyclerView>(R.id.list) as RecyclerView
            recyclerView.layoutManager = GridLayoutManager(context, 2)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = MyQuoteAdapter(products)
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
            var view = inflater.inflate(R.layout.fragment_blue, container, false)
            loadView(view)
            return view
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)


            for (i in 0..100){

                products.add(Product("Blue Cake","https://via.placeholder.com/300.png/00000",20.00))
            }

            adapter = MyQuoteAdapter(products)
            adapter.replaceItems(products)
            list.adapter = adapter
        }
    }