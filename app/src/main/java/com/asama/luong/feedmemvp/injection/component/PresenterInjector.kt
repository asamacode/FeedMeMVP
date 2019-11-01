package com.asama.luong.feedmemvp.injection.component

import com.asama.luong.feedmemvp.base.BaseView
import com.asama.luong.feedmemvp.injection.module.ContextModule
import com.asama.luong.feedmemvp.injection.module.NetworkModule
import com.asama.luong.feedmemvp.ui.post.PostPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {

        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}