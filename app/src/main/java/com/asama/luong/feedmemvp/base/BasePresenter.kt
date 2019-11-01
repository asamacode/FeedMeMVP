package com.asama.luong.feedmemvp.base

import com.asama.luong.feedmemvp.injection.component.DaggerPresenterInjector
import com.asama.luong.feedmemvp.injection.component.PresenterInjector
import com.asama.luong.feedmemvp.injection.module.ContextModule
import com.asama.luong.feedmemvp.injection.module.NetworkModule
import com.asama.luong.feedmemvp.ui.post.PostPresenter

abstract class BasePresenter<out V: BaseView>(protected val view: V) {

    private val injector : PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */

    private fun inject() {
        when (this) {
            is PostPresenter -> injector.inject(this)
        }
    }
}