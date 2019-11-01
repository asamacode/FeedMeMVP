package com.asama.luong.feedmemvp.ui.post

import androidx.annotation.StringRes
import com.asama.luong.feedmemvp.base.BaseView
import com.asama.luong.feedmemvp.model.Post

interface PostView : BaseView {

    fun updatePosts(posts : List<Post>)

    fun showError(error : String)

    fun showError(@StringRes errorResId : Int){
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}