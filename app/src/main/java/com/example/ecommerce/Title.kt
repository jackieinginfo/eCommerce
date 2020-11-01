package com.example.ecommerce

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ecommerce.databinding.FragmentTitelBinding


class Title : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState:
        Bundle?
    ): View? {
        val titlebinding =
            DataBindingUtil.inflate<FragmentTitelBinding>(
                inflater,
                R.layout.fragment_titel,
                container,
                false
            )


        titlebinding.back.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_title2_to_welcom)
        }

        setHasOptionsMenu(true)
        return titlebinding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}


//  v.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
// titlebinding.back.setOnClickListener { view: View ->
// view.findNavController().navigate(R.id.action_title2_to_welcom)
//}

