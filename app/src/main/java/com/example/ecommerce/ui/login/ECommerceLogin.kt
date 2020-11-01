package com.example.ecommerce.ui.login

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentECommerceLoginBinding

class eCommerceLogin : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState:
        Bundle?
    ): View? {

        val binding =
            DataBindingUtil.inflate<FragmentECommerceLoginBinding>(
                inflater,
                com.example.ecommerce.R.layout.fragment_e_commerce_login, container, false
            )


        binding.login.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_eCommerceLogin_to_welcom)
        }

        setHasOptionsMenu(true)
        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.passwort, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}

