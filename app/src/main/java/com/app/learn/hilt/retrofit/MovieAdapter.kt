package com.app.learn.hilt.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.learn.databinding.MovieItemBinding
import com.app.learn.hilt.retrofit.model.ResponseMoviesList
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieAdapter @Inject constructor(@ApplicationContext context: Context) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var binding: MovieItemBinding

    // we can use context provided by Hilt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun getItemViewType(position: Int): Int { // for avoid of duplicate
        return position
    }

    inner class ViewHolder() : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ResponseMoviesList.Data) {
            binding.apply {
                movieName.text = item.title
                movieImg.load(item.poster){
                    crossfade(true) // for animation
                    crossfade(300)
                }
            }
        }

    }

    private var differCallBack = object : DiffUtil.ItemCallback<ResponseMoviesList.Data>() {
        override fun areItemsTheSame(
            oldItem: ResponseMoviesList.Data,
            newItem: ResponseMoviesList.Data
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ResponseMoviesList.Data,
            newItem: ResponseMoviesList.Data
        ): Boolean {
            return oldItem == newItem
        }

    }

    var differ = AsyncListDiffer(this, differCallBack)

}