package com.jef.tripgeniusapp.ui.profile

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jef.tripgeniusapp.R
import com.jef.tripgeniusapp.databinding.FragmentProfileBinding

//class ProfileFragment : Fragment() {
//
//    companion object {
//        fun newInstance() = ProfileFragment()
//    }
//
//    private lateinit var viewModel: ProfileViewModel
//    private lateinit var binding : FragmentProfileBinding
//    private lateinit var get_name : TextView
//    private lateinit var get_gender : TextView
//    private lateinit var get_location : TextView
//    private lateinit var get_email : TextView
//    private lateinit var get_phone : TextView
//    private lateinit var get_age : TextView
//
//    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
//        get_name = binding.getName
//        get_gender = binding.getGender
//        get_location = binding.getLocation
//        get_email = binding.getEmail
//        get_phone = binding.getPhone
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
//
//    }
//
//}