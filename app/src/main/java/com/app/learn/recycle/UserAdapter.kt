package com.app.learn.recycle

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.learn.databinding.UserItemBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder> () {

    private lateinit var binding : UserItemBinding

    // setting binding for changing item's view and returning ViewHolder from our adapter
    // ViewHolder means a place that items show in there (our recycle view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = UserItemBinding.inflate(inflater , parent , false)
        return ViewHolder()
    }

    // getting data from differ based on position and setting in ViewHolder to show each item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    // counting items and show
    // the items that showed in view depends on returning number from this func
    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    // we should creating a class of RecyclerView.ViewHolder to show items in there
    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){

        @SuppressLint("SetTextI18n")
        fun setData (item: UsersModel){
            binding.textview.text = "${ item.name }  ${item.age}"
        }

    }

    // setting a callback for update and check duplicates before showing list to user
    private val itemChangeCallback = object : DiffUtil.ItemCallback<UsersModel>(){
        override fun areItemsTheSame(oldItem: UsersModel, newItem: UsersModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UsersModel, newItem: UsersModel): Boolean {
            return oldItem == newItem
        }
    }

    // build a differ and add callback to it
    val differ = AsyncListDiffer(this , itemChangeCallback)

}