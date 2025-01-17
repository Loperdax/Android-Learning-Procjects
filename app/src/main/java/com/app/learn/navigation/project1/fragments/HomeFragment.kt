package com.app.learn.navigation.project1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.learn.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            send.setOnClickListener(){
                // using home fragment directions and add data
                val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(editTextId.text.toString())
                findNavController().navigate(direction)

                // we can simply navigate without sending data 👇
//                findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
            }
        }
    }

}