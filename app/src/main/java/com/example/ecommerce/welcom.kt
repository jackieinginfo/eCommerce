package com.example.ecommerce

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ecommerce.databinding.FragmentWelcomBinding


class welcom : Fragment() {


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
            view.findNavController().navigate(R.id.action_welcom_to_eCommerceLogin)
        }
        setHasOptionsMenu(true)
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