package com.app.learn.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.app.learn.R
import com.app.learn.databinding.FragmentDetailBinding
import com.app.learn.databinding.FragmentHomeBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    // init args by navArgs to get sent args
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textDetail.text = args.data

    }

}