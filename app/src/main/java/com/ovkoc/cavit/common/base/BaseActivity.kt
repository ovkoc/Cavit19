package com.ovkoc.cavit.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ovkoc.cavit.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right)
    }

}