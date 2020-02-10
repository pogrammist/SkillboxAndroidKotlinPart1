package com.example.kotlin113gradle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = """
            BuildType=${BuildConfig.BUILD_TYPE}
            Flavor=${BuildConfig.FLAVOR}
            VersionCode=${BuildConfig.VERSION_CODE}
            VersionName=${BuildConfig.VERSION_NAME}
        """.trimIndent()
    }
}
