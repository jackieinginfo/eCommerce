package com.example.ecommerce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarteist.autoimageslider.SliderAnimations
import androidx.databinding.DataBindingUtil
import com.example.ecommerce.databinding.ActivityMainBinding
import com.example.ecommerce.ui.login.eCommerceLogin
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
{
    private lateinit var activitiesBinding: ActivityMainBinding
    private  val ecommercelogin: eCommerceLogin = eCommerceLogin()
    private val newWordActivityRequestCode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitiesBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        //EcommerceLogin


        //autoSlider
        val imageSliderAdapter = ImageSliderAdapter(this)
        main_image_android.setSliderAdapter(imageSliderAdapter)
        main_image_android.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        main_image_android.startAutoCycle()
        imageSliderAdapter.renewItems(fetchSliderItemList())


        main_recycler_view.apply {
            adapter =  ItemUnitAdapter()
            layoutManager = LinearLayoutManager(context)
            }
        main_recycler.apply {
            adapter = ItemUnit2Adapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        }
    }

    private fun fetchSliderItemList(): List<String> {

        val items = arrayListOf<String>()
       // pixel photo to be fecht from link in video description
        //https://images.pexels.com/photos/4110012/pexels-photo-4110012.jpeg?cs=srgb&dl=pexels-polina-tankilevitch-4110012.jpg&fm=jpg
        items.add("https://images.pexels.com/photos/3905697/pexels-photo-3905697.jpeg?cs=srgb&dl=pexels-anna-shvets-3905697.jpg&fm=jpg")
        items.add("https://images.pexels.com/photos/2680603/pexels-photo-2680603.jpeg?cs=srgb&dl=pexels-anna-tukhfatullina-food-photographerstylist-2680603.jpg&fm=jpg")
        items.add("https://images.pexels.com/photos/1070850/pexels-photo-1070850.jpeg?cs=srgb&dl=pexels-daria-shevtsova-1070850.jpg&fm=jpg")
        items.add("https://images.pexels.com/photos/3992381/pexels-photo-3992381.jpeg?cs=srgb&dl=pexels-cottonbro-3992381.jpg&fm=jpg")
        items.add("https://images.pexels.com/photos/4686833/pexels-photo-4686833.jpeg?cs=srgb&dl=pexels-cottonbro-4686833.jpg&fm=jpg")
        return items
    }
}