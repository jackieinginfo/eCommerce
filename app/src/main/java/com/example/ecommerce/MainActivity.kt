package com.example.ecommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toast.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.ui.login.eCommerceLogin
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_e_commerce_login.view.*


class MainActivity : AppCompatActivity()
{
    private lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageSliderAdapter = ImageSliderAdapter(this)
        main_image_android.setSliderAdapter(imageSliderAdapter)
        main_image_android.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        main_image_android.startAutoCycle()
        imageSliderAdapter.renewItems(fetchSliderItemList())


        main_recycler_view.apply {
            adapter =  ItemUnitAdapter()
            layoutManager = LinearLayoutManager(context)
            }
        main_recycler_view.apply {
            adapter = Itemunit2Adapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        }
    }

    private fun fetchSliderItemList(): List<String> {

        val items = arrayListOf<String>()
       // pixel photo to be fecht from link in video description
        //https://images.pexels.com/photos/4110012/pexels-photo-4110012.jpeg?cs=srgb&dl=pexels-polina-tankilevitch-4110012.jpg&fm=jpg
        items.add("https://images.pexels.com/photos/3905697/pexels-photo-3905697.jpeg?cs=srgb&dl=pexels-anna-shvets-3905697.jpg&fm=jpg")
        items.add("https://images.pexels.com/photos/2680603/pexels-photo-2680603.jpeg?cs=srgb&dl=pexels-anna-tukhfatullina-food-photographerstylist-2680603.jpg&fm=jpg")
        items.add("https://images.pexels.com/photos/4686833/pexels-photo-4686833.jpeg?cs=srgb&dl=pexels-cottonbro-4686833.jpg&fm=jpg")
        return items
    }
}