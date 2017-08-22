package com.powervision.gcs.ui.fgt.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.powervision.gcs.R


/**
 * A simple [Fragment] subclass.
 */
class MediaFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.pv_main_media_layout, container, false)
    }

}// Required empty public constructor
