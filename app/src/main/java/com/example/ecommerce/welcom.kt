package com.example.ecommerce

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.data.model.Product
import com.example.ecommerce.databinding.FragmentWelcomBinding
import kotlinx.android.synthetic.main.fragment_blue.*


class welcom : Fragment() {

    val products = arrayListOf<Product>(        )

    companion object {

        @JvmStatic
        fun newInstance() =
            welcom().apply {
                arguments = Bundle().apply {
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        adapter = MyQuoteAdapter(products)
        adapter.replaceItems(products)

        list.adapter = adapter
    }

    private lateinit var adapter: MyQuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            // columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState:
        Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<FragmentWelcomBinding>(
                inflater,
                com.example.ecommerce.R.layout.fragment_welcom, container, false
            )


        binding.logginPerson.setOnClickListener{
                view: View ->
            view.findNavController().navigate(R.id.action_welcom_to_activityFragment)
        }

        binding.cart.setOnClickListener{
                view: View ->
            view.findNavController().navigate(R.id.action_welcom_to_title2)
        }

        binding.mic.setOnClickListener{
                view: View ->
            view.findNavController().navigate(R.id.action_welcom_to_eCommerceLogin)
        }



        setHasOptionsMenu(true)

        var view = inflater.inflate(R.layout.fragment_welcom, container, false)
        loadView(view)
        return binding.root

    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.welcom, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}