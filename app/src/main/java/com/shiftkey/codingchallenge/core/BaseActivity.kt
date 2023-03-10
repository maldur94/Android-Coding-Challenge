package com.shiftkey.codingchallenge.core

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onSupportNavigateUp(): Boolean {
        return true
    }
}