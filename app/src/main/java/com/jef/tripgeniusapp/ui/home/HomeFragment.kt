package com.jef.tripgeniusapp.ui.home

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jef.tripgeniusapp.R
import com.jef.tripgeniusapp.ViewModelFactory
import com.jef.tripgeniusapp.adapter.DestinasiAdapter
import com.jef.tripgeniusapp.databinding.FragmentHomeBinding
import com.jef.tripgeniusapp.databinding.FragmentProfileBinding
import com.jef.tripgeniusapp.model.UserPreference
import com.jef.tripgeniusapp.model.response.ListDestinasi
import com.jef.tripgeniusapp.ui.login.LoginActivity
import com.jef.tripgeniusapp.ui.profile.ProfileViewModel

class HomeFragment : Fragment() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    companion object {
        fun newInstance() = HomeFragment()
    }
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding : FragmentHomeBinding
    private lateinit var get_name : TextView
    private lateinit var get_gender : TextView
    private lateinit var get_location : TextView
    private lateinit var get_email : TextView
    private lateinit var get_phone : TextView
    private lateinit var get_age : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvDestinasi.layoutManager = layoutManager

        setupViewModel()

    }
    private fun setupViewModel() {
        homeViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(requireContext().dataStore))
        )[HomeViewModel::class.java]
        homeViewModel.getUser().observe(this) { user ->
            if (user.accessToken.isNotEmpty()) {
                homeViewModel.getDestinastion(user.accessToken)
            } else {
                Log.e(ContentValues.TAG, "onFailure")
            }
        }
        homeViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        homeViewModel.listDestinasi.observe(this) { destinasi ->
            setDestination(destinasi.data as List<ListDestinasi>)
        }
    }
    private fun setDestination(destinasi: List<ListDestinasi>) {
        val destinasiAdapter = DestinasiAdapter(destinasi)
        binding.rvDestinasi.adapter = destinasiAdapter
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}