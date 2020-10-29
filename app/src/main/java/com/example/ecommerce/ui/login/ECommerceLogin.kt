package com.example.ecommerce.ui.login

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentECommerceLoginBinding

class eCommerceLogin : Fragment()
{

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState:
                              Bundle?): View?
    {

        val binding =
            DataBindingUtil.inflate<FragmentECommerceLoginBinding>(
                inflater,
                com.example.ecommerce.R.layout.fragment_e_commerce_login, container, false
            )


        binding.login.setOnClickListener{
                view: View ->
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
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

  //  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  //      super.onViewCreated(view, savedInstanceState)
  //      loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory())
  //          .get(LoginViewModel::class.java)
//
  //      val usernameEditText = view.findViewById<EditText>(R.id.username)
  //      val passwordEditText = view.findViewById<EditText>(R.id.password)
  //      val loginButton = view.findViewById<Button>(R.id.login)
  //      val loadingProgressBar = view.findViewById<ProgressBar>(R.id.loading)
//
  //      loginViewModel.loginFormState.observe(this,
  //          Observer { loginFormState ->
  //              if (loginFormState == null) {
  //                  return@Observer
  //              }
  //              loginButton.isEnabled = loginFormState.isDataValid
  //              loginFormState.usernameError?.let {
  //                  usernameEditText.error = getString(it)
  //              }
  //              loginFormState.passwordError?.let {
  //                  passwordEditText.error = getString(it)
  //              }
  //          })
//
  //      loginViewModel.loginResult.observe(this,
  //          Observer { loginResult ->
  //              loginResult ?: return@Observer
  //              loadingProgressBar.visibility = View.GONE
  //              loginResult.error?.let {
  //                  showLoginFailed(it)
  //              }
  //              loginResult.success?.let {
  //                  updateUiWithUser(it)
  //              }
  //          })
//
  //      val afterTextChangedListener = object : TextWatcher {
  //          override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
  //              // ignore
  //          }
//
  //          override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
  //              // ignore
  //          }
//
  //          override fun afterTextChanged(s: Editable) {
  //              loginViewModel.loginDataChanged(
  //                  usernameEditText.text.toString(),
  //                  passwordEditText.text.toString()
  //              )
  //          }
  //      }
  //      usernameEditText.addTextChangedListener(afterTextChangedListener)
  //      passwordEditText.addTextChangedListener(afterTextChangedListener)
  //      passwordEditText.setOnEditorActionListener { _, actionId, _ ->
  //          if (actionId == EditorInfo.IME_ACTION_DONE) {
  //              loginViewModel.login(
  //                  usernameEditText.text.toString(),
  //                  passwordEditText.text.toString()
  //              )
  //          }
  //          false
  //      }
//
  //      loginButton.setOnClickListener {
  //          loadingProgressBar.visibility = View.VISIBLE
  //          loginViewModel.login(
  //              usernameEditText.text.toString(),
  //              passwordEditText.text.toString()
  //          )
  //      }
  //  }
//
  //  private fun updateUiWithUser(model: LoggedInUserView) {
  //      val welcome = getString(R.string.welcome) + model.displayName
  //      // TODO : initiate successful logged in experience
  //      val appContext = context?.applicationContext ?: return
  //      Toast.makeText(appContext, welcome, Toast.LENGTH_LONG).show()
  //  }
//
  //  private fun showLoginFailed(@StringRes errorString: Int) {
  //      val appContext = context?.applicationContext ?: return
  //      Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
  //  }
}