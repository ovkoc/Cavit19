package com.ovkoc.cavit.ui.custom.container

import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import com.ovkoc.cavit.R

class ContainerViewBindingAdapters {

    companion object {
        @JvmStatic
        @BindingAdapter("app:loading_visible")
        fun containerViewLoading(view: ContainerView, visibility: Int) {
            val loading = view.findViewById<FrameLayout>(R.id.loadingLayout)
            loading.visibility = visibility
        }

        @JvmStatic
        @BindingAdapter("app:error_visible")
        fun containerViewError(view: ContainerView, visibility: Int) {
            val error = view.findViewById<FrameLayout>(R.id.errorLayout)
            error.visibility = visibility
        }

        @JvmStatic
        @BindingAdapter("app:on_retry_click")
        fun containerViewErrorRetry(view: ContainerView, listener: View.OnClickListener) {
            val retry = view.findViewById<Button>(R.id.error_retry)
            retry.setOnClickListener(listener)
        }

    }


}