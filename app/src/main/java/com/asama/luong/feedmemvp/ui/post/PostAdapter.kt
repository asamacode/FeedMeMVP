package com.asama.luong.feedmemvp.ui.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.asama.luong.feedmemvp.R
import com.asama.luong.feedmemvp.databinding.ItemPostBinding
import com.asama.luong.feedmemvp.model.Post

class PostAdapter(private val context: Context) : RecyclerView.Adapter<PostViewHolder>() {

    private var posts : List<Post> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding : ItemPostBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }
}

class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.post = post
        binding.executePendingBindings()
    }
}