package com.shiftkey.codingchallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shiftkey.codingchallenge.core.BaseActivity
import com.shiftkey.codingchallenge.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
