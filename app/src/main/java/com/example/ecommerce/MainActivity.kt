package com.example.ecommerce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.ecommerce.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var Binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerLayout = Binding.drawerLayout

        setSupportActionBar(Binding.toolbar)
        val navController = this.findNavController(R.id.nav_host_fragment)
       NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
       NavigationUI.setupWithNavController(Binding.navView, navController)


/*
        val products = arrayListOf<Product>()
        for (i in 0..100) {
            products.add(Product("cake rosa", "https://via.placeholder.com/150/150", 1.99))

        }

        recycler_view.apply {


            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = ItemUnitAdapter(products)
            setHasFixedSize(true)
        }
*/





    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

}