package com.example.ecommerce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.ecommerce.databinding.ActivityMainBinding
import com.example.ecommerce.ui.login.eCommerceLogin


class MainActivity : AppCompatActivity() {
    private lateinit var Binding: ActivityMainBinding
    private val ecommercelogin: eCommerceLogin = eCommerceLogin()
    private val newWordActivityRequestCode = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

           setSupportActionBar(Binding.toolbar)

    }

}