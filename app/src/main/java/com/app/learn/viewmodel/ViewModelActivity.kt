package com.app.learn.viewmodel

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.learn.databinding.ActivityViewmodelBinding
import com.app.learn.viewmodel.recycler.ItemAdapter

class ViewModelActivity : AppCompatActivity() {

    private lateinit var binding : ActivityViewmodelBinding
    private val viewModel : MainViewModel by viewModels()
    private val adapter: ItemAdapter by lazy { ItemAdapter() }

//    private var counter : Int = 0

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewmodelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            // setting text
            text1.text = viewModel.counter.toString()
            btnAdd.setOnClickListener {
                // without viewModel
//                counter++
//                text1.text = counter.toString()

                // Using ViewModel
                viewModel.incrementCounter()
                text1.text = viewModel.counter.toString()
            }


            adapter.differ.submitList(viewModel.items)

            recyclerView.adapter= adapter
            recyclerView.layoutManager = LinearLayoutManager(this@ViewModelActivity)
        }
    }

}