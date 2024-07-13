package com.app.learn.roomDb

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.learn.Constants.ID_EXTRA
import com.app.learn.databinding.UserItemBinding
import com.app.learn.roomDb.db.UserEntity

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var binding : UserItemBinding
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = UserItemBinding.inflate(inflater , parent , false)
        context = parent.context
        return  ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind (item: UserEntity) {
            binding.textview.text = "${item.id}- ${item.name}   ${item.age}"
            //
            binding.root.setOnClickListener{
                val intent = Intent(context , EditUserActivity::class.java)
                // sending name to update activity
                intent.putExtra(ID_EXTRA , item.name)
                context.startActivity(intent)
            }
        }

    }

    private val differCallback = object :  DiffUtil.ItemCallback<UserEntity>(){
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this , differCallback)

}