package com.ovkoc.cavit.ui.custom.toolbar

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import com.ovkoc.cavit.R
import com.ovkoc.cavit.common.extensions.hideKeyboard
import com.ovkoc.cavit.common.extensions.showKeyboard
import kotlinx.android.synthetic.main.cavit_toolbar.view.*

class CavitToolbar : Toolbar {

    private lateinit var contentView: View
    private lateinit var searchEditText: EditText

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initializeViews()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initializeViews() {

        contentView = LayoutInflater.from(context)
            .inflate(R.layout.cavit_toolbar, this, true)

        contentView.searchButton.setOnClickListener {
            onSearchClicked()
        }

        contentView.searchEditText.visibility = View.GONE

        searchEditText = contentView.searchEditText

        searchEditText.setOnTouchListener { v, event ->

            if (event.action == MotionEvent.ACTION_DOWN) {
                if (event.rawX >= searchEditText.right - searchEditText.compoundDrawables[2].bounds.width()) {
                    onCloseClicked(v)
                }
            }
            false
        }
    }

    private fun onSearchClicked() {
        contentView.searchButton.visibility = View.GONE
        contentView.searchEditText.visibility = View.VISIBLE

        searchEditText.showKeyboard()
    }

    fun onCloseClicked(v: View) {
        searchEditText.visibility = View.GONE
        searchEditText.setText("")
        v.hideKeyboard()
        searchButton.visibility = View.VISIBLE
    }

    fun onSearchTextChangeListener(listenText: (String) -> Unit) {
        searchEditText.addTextChangedListener {
            listenText(it.toString())
        }
    }


}