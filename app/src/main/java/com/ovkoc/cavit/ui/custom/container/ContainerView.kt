package com.ovkoc.cavit.ui.custom.container

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.ovkoc.cavit.databinding.ViewContainerBinding

class ContainerView : FrameLayout {

    private lateinit var binding: ViewContainerBinding

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        initializeViews()

    }

    private fun initializeViews() {
        binding = ViewContainerBinding.inflate(
            LayoutInflater.from(context), this, true
        )


    }


}