package com.khayrultw.playground.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.khayrultw.playground.R
import com.khayrultw.playground.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)
        onBindView()
    }

    private fun onBindView() {
       binding.mbMenu.setOnClickListener {
           navigateToMenu()
       }

        binding.ivAndroid.setOnClickListener {
            showPopupMenu(it)
        }
    }

    private fun navigateToMenu() {
        val action = HomeFragmentDirections.actionHomeToMenu()
        navController.navigate(action)
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.setForceShowIcon(true)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.item1 -> {
                    Toast.makeText(requireContext(), it.title, Toast.LENGTH_LONG).show()
                }

                R.id.item2 -> {
                    Toast.makeText(requireContext(), it.title, Toast.LENGTH_LONG).show()
                }
            }
            return@setOnMenuItemClickListener true
        }
    }
}