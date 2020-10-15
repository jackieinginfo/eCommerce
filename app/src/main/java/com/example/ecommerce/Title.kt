package com.example.ecommerce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.ecommerce.databinding.FragmentTitelBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Title : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container:
                                         ViewGroup?, savedInstanceState:
                                         Bundle?): View?
    {
        val titlebinding  = DataBindingUtil.inflate<FragmentTitelBinding>(inflater,R.layout.fragment_titel, container, false)

        //  v.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())

        return titlebinding.root
    }
}

