package com.jef.tripgeniusapp.ui.home

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jef.tripgeniusapp.R
import com.jef.tripgeniusapp.ViewModelFactory
import com.jef.tripgeniusapp.databinding.FragmentHomeBinding
import com.jef.tripgeniusapp.model.UserPreference
import com.jef.tripgeniusapp.ui.login.LoginActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
//class HomeFragment : Fragment() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var homeViewModel: HomeViewModel
//    private lateinit var binding : FragmentHomeBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentHomeBinding.inflate(inflater, container, false)
//        return binding.root
//
//        setUpViewModel()
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        recyclerView = binding.rvDestinasi
//        binding.rvDestinasi.layoutManager = LinearLayoutManager(requireActivity())
//        var position = 0
//        var username: String = ""
//        var type: String = ""
//        arguments?.let {
//            position = it.getInt(ARG_POSITION)
//            username = it.getString(ARG_USERNAME)!!
//        }
//    }
//
//    private fun setUpViewModel() {
//
//        homeViewModel.isLoading.observe(this) {
//            showLoading(it)
//        }
//    }
//    private fun showLoading(isLoading: Boolean) {
//        if (isLoading) {
//            binding.progressBar.visibility = View.VISIBLE
//        } else {
//            binding.progressBar.visibility = View.GONE
//        }
//    }
//    companion object {
//        const val ARG_POSITION: String = "position"
//        const val ARG_USERNAME: String = "username"
//    }
//}username