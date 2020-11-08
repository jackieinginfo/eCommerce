package com.example.ecommerce.ui.login

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentECommerceLoginBinding
import com.example.ecommerce.firebase.LoginViewModel
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth


class eCommerceLogin : Fragment() {
    companion object {
        const val TAG = "eCommerceLogin"
        const val SIGN_IN_RESULT_CODE = 1001
    }



    // Get a reference to the ViewModel scoped to this Fragment
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: FragmentECommerceLoginBinding
    private lateinit var i : TextView




    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_e_commerce_login,
            container,
            false
        )

        binding.back.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_eCommerceLogin_to_welcom)

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeAuthenticationState()


        binding.authButton.setOnClickListener { launchSignInFlow() }

    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                // User successfully signed in
                Log.i(
                    TAG, "Successfully signed in user ${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
            } else {

                Log.i(TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }
    }


    private fun observeAuthenticationState() {
        val factToDisplay = viewModel.getFactToDisplay(requireContext())

        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {
                    binding.welcomeText.text = getFactWithPersonalization(factToDisplay)
                    binding.back.text= "Shop Now"
                    binding.authButton.text = getString(R.string.logout_button_text)

                    binding.authButton.setOnClickListener {
                        AuthUI.getInstance().signOut(requireContext())
                    }
                }
                else -> {
                    binding.welcomeText.text = factToDisplay
                    binding.back.text = "Shop again"
                    binding.authButton.text = getString(R.string.login_button_text)

                    binding.authButton.setOnClickListener {
                        launchSignInFlow()
                    }
                }
            }
        })
    }


    //add UserName
    @SuppressLint("StringFormatMatches")
    private fun getFactWithPersonalization(fact: String): String {
        return String.format(
            resources.getString(
                R.string.welcome_message_authed,
                FirebaseAuth.getInstance().currentUser?.displayName,
                Character.toLowerCase(fact[0]) + fact.substring(1), R.drawable.welcome
            )
        )
    }





    //Fecht Email from Google Android
    private fun launchSignInFlow() {

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )




        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(), eCommerceLogin.SIGN_IN_RESULT_CODE
        )
    }
}