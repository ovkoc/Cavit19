package com.ovkoc.cavit.common

import android.content.Context

object ApplicationContext {
    private lateinit var _context: Context

    fun set(context: Context) {
        if(!::_context.isInitialized) {
            _context = context
        }
    }

    fun get(): Context {
        return _context
    }
}
