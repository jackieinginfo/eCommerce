package com.example.ecommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toast.*
import com.example.ecommerce.ui.login.eCommerceLogin
import kotlinx.android.synthetic.main.fragment_e_commerce_login.view.*


class MainActivity : AppCompatActivity()
{
    private lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.logg)

        login.setOnClickListener{
            val intent = Intent(this@MainActivity, eCommerceLogin::class.java)
        }
        //loginBtn= findViewById(R.id.main_login_bt)




    }
}