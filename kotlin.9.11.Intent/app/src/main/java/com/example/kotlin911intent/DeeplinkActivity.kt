package com.example.kotlin911intent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activitu_deeplink.*

class DeeplinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitu_deeplink)
        handleIntentData()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntentData()
    }

    private fun handleIntentData() {
        intent.data?.let { data ->
            urlTextView.text = data.host + data.path
        }
    }
}