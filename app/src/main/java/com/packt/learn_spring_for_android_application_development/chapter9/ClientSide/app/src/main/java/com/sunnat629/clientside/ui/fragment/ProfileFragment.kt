package com.sunnat629.clientside.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunnat629.clientside.R

class ProfileFragment: Fragment() {
    // Create newInstances() function for creating of the fragment. This is called the factory method.
    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    // Create the view hierarchy controlled by the fragment.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_profile, container,false)

        return view
    }
}