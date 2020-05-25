package com.example.kotlin68views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val progressBar = ProgressBar(this).apply {
//            id = View.generateViewId()
//            layoutParams = ConstraintLayout.LayoutParams(
//                ConstraintLayout.LayoutParams.WRAP_CONTENT,
//                ConstraintLayout.LayoutParams.MATCH_PARENT
//            ).apply {
//                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
//                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
//            }
//        }
//        container.addView(progressBar)

//        val progressBar = ProgressBar(this).apply {
//            id = View.generateViewId()
//        }
//        container.addView(progressBar)
//        ConstraintSet().apply {
//            constrainHeight(progressBar.id, ConstraintSet.WRAP_CONTENT)
//            constrainWidth(progressBar.id, ConstraintSet.WRAP_CONTENT)
//            connect(progressBar.id,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT)
//            connect(progressBar.id,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)
//            connect(progressBar.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP)
//            connect(progressBar.id,ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM)
//            setMargin(progressBar.id, ConstraintSet.LEFT, 110)
//            applyTo(container)
//        }

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
            id = View.generateViewId()
        }
        container.addView(progressBar)
        val set = ConstraintSet().apply {
            constrainHeight(progressBar.id, ConstraintSet.WRAP_CONTENT)
            constrainWidth(progressBar.id, ConstraintSet.WRAP_CONTENT)
            connect(progressBar.id,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT)
            connect(progressBar.id,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)
            connect(progressBar.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP)
            connect(progressBar.id,ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM)
            applyTo(container)
        }

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
