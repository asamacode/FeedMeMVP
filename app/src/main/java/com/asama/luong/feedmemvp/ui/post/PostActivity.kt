package com.asama.luong.feedmemvp.ui.post

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.asama.luong.feedmemvp.R
import com.asama.luong.feedmemvp.base.BaseActivity
import com.asama.luong.feedmemvp.databinding.ActivityPostBinding
import com.asama.luong.feedmemvp.model.Post

class PostActivity : BaseActivity<PostPresenter>(), PostView {

    private lateinit var binding: ActivityPostBinding

    private val postAdapter = PostAdapter(this)

    override fun instantiatePresenter(): PostPresenter {
        return PostPresenter(this)
    }

    override fun updatePosts(posts: List<Post>) {
        postAdapter.updatePosts(posts)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        binding.adapter = postAdapter

        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}
