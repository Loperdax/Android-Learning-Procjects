package com.app.learn.hilt.room

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.learn.databinding.NoteItemBinding
import com.app.learn.hilt.room.db.NoteModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteAdapter @Inject constructor(): RecyclerView.Adapter<NoteAdapter.ViewHolder>(){

    private lateinit var binding: NoteItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return  differ.currentList.size
    }

    inner class ViewHolder  : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(item: NoteModel) {
            binding.apply {
                textview.text = "${item.id} - ${item.title}"
                root.setOnClickListener{
                    onItemClickListener?.let {
                        it(item)
                    }
                }
            }

        }
    }


    // for detect click on each item
    private var onItemClickListener: ((NoteModel) -> Unit)? = null

    fun setOnItemClickListener(listener : ((NoteModel) -> Unit)) {
        onItemClickListener = listener
    }

    private val differCallback = object : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
}