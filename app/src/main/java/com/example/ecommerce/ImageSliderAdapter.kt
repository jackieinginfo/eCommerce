package com.example.ecommerce

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItem
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.items_image_slider.view.*
import java.util.ArrayList

class ImageSliderAdapter(private val context: Context) :
    SliderViewAdapter<ImageSliderAdapter.ImageSliderVH>() {
    private var mSlidetItems: List<String> = ArrayList()

    fun renewItems(sliderItem: List<String>) {
        mSlidetItems = sliderItem
        notifyDataSetChanged()
    }

    class ImageSliderVH(view: View) : SliderViewAdapter.ViewHolder(view) {
        private val imageView = view.image_slider_iv

        fun bind(context: Context, sliderItem: String) {
            Glide.with(imageView.context)
                .load(sliderItem)
                .centerCrop()
                .into(imageView)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup?): ImageSliderVH {
        val inflate: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.items_image_slider, null)
        return ImageSliderVH(inflate)
    }

    override fun getCount() = mSlidetItems.size

    override fun onBindViewHolder(viewHolder: ImageSliderVH?, position: Int) {
        if (viewHolder != null) {
            viewHolder.bind(context,mSlidetItems[position])

        }
    }

}
