package com.example.kotlin214gradle

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = """
            Flavor=${BuildConfig.FLAVOR}
            BuildType=${BuildConfig.BUILD_TYPE}
            VersionCode=${BuildConfig.VERSION_CODE}
            VersionName=${BuildConfig.VERSION_NAME}
            ApplicationID=${BuildConfig.APPLICATION_ID}
        """.trimIndent()
    }
}
