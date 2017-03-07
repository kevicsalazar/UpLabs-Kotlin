package com.kevicsalazar.uplabs.presentation.presenters


import com.kevicsalazar.uplabs.domain.DataHelper
import com.kevicsalazar.uplabs.presentation.BasePresenter
import com.kevicsalazar.uplabs.presentation.PerActivity
import com.kevicsalazar.uplabs.domain.model.Post
import javax.inject.Inject

/**
 * Created by Kevin.
 */
@PerActivity
class PostPresenter @Inject constructor(val dh: DataHelper) : BasePresenter<PostPresenter.View>() {

    fun getPost(type: String, id: String) {
        dh.getPost(type, id)?.let {
            view?.setupPostImage(it)
            view?.showPostInfo(it)
            view?.setupButtons(it)
        }
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onDestroy() {
        view = null
    }

    interface View : BaseView {

        fun setupPostImage(post: Post)

        fun showPostInfo(post: Post)

        fun setupButtons(post: Post)

    }

}