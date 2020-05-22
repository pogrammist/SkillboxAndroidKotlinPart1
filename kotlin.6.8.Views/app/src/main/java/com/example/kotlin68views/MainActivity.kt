package com.example.kotlin68views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.Layout
import android.text.TextWatcher
import android.view.Gravity
import android.widget.*
import androidx.constraintlayout.widget.ConstraintSet
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageLink =
            "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
        Glide.with(this).load(imageLink).into(imageView)

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!emailEditText.isEmailValid()) emailEditText.error =
                    "Please Enter Email Address"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loginButton.isEnabled = isAuthValid()
            }
        })

        passEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (passEditText.text.isBlank()) passEditText.error = "Please Enter Password"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loginButton.isEnabled = isAuthValid()
            }
        })

        checkBox.setOnCheckedChangeListener { _, _ ->
            loginButton.isEnabled = isAuthValid()
        }

        loginButton.setOnClickListener {
            makeLongBar()
        }
    }

    private fun EditText.isEmailValid(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()
    }

    private fun isAuthValid(): Boolean {
        return emailEditText.isEmailValid() && passEditText.text.isNotBlank() && checkBox.isChecked
    }

    private fun makeLongBar() {
        emailEditText.isEnabled = false
        passEditText.isEnabled = false
        checkBox.isEnabled = false
        loginButton.isEnabled = false
        val progressBar = ProgressBar(this).apply {
            layoutParams = RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            ).apply {
                addRule(RelativeLayout.CENTER_IN_PARENT)
            }
        }
        container.addView(progressBar)
        Handler().postDelayed({
            emailEditText.text.clear()
            emailEditText.isEnabled = true
            passEditText.text.clear()
            passEditText.isEnabled = true
            checkBox.isEnabled = true
            checkBox.isChecked = false
            loginButton.isEnabled = true
            container.removeView(progressBar)
            Toast.makeText(this, "No connection", Toast.LENGTH_SHORT).show()
        }, 2000)
    }
}
