package com.example.kotlin68views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintSet
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        private const val FORM_STATE = "Form state"
    }

    private val tag = "MainActivity"
    private var state: FormState? = FormState(true, "")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(FORM_STATE, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getParcelable(FORM_STATE)
        stateTextView.text = state?.message ?: ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v(tag, "onCreate was called")
        Log.d(tag, "onCreate was called")
        Log.i(tag, "onCreate was called")
        Log.w(tag, "onCreate was called")
        Log.e(tag, "onCreate was called")

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
            if (emailEditText.text.toString().substringAfter('@') != "gmail.com") {
                emailEditText.error = "Email must be gmail.com"
                stateTextView.text = getString(R.string.form_not_true)
                state = FormState(false, getString(R.string.form_not_true))
            }
            if (passEditText.text.length < 10) {
                passEditText.error = "Password must be 10 characters"
                stateTextView.text = getString(R.string.form_not_true)
                state = FormState(false, getString(R.string.form_not_true))
            } else {
                stateTextView.text = ""
                state = FormState(true, "")
                makeLongBar()
            }
        }

        imageView.setOnClickListener {
            Thread.sleep(6000)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(tag, "onStart was called")
        Log.d(tag, "onStart was called")
        Log.i(tag, "onStart was called")
        Log.w(tag, "onStart was called")
        Log.e(tag, "onStart was called")
    }

    override fun onResume() {
        super.onResume()
        Log.v(tag, "onResume was called")
        Log.d(tag, "onResume was called")
        Log.i(tag, "onResume was called")
        Log.w(tag, "onResume was called")
        Log.e(tag, "onResume was called")
    }

    override fun onPause() {
        super.onPause()
        Log.v(tag, "onPause was called")
        Log.d(tag, "onPause was called")
        Log.i(tag, "onPause was called")
        Log.w(tag, "onPause was called")
        Log.e(tag, "onPause was called")
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag, "onStop was called")
        Log.d(tag, "onStop was called")
        Log.i(tag, "onStop was called")
        Log.w(tag, "onStop was called")
        Log.e(tag, "onStop was called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag, "onDestroy was called")
        Log.d(tag, "onDestroy was called")
        Log.i(tag, "onDestroy was called")
        Log.w(tag, "onDestroy was called")
        Log.e(tag, "onDestroy was called")
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
            connect(progressBar.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
            connect(
                progressBar.id,
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT
            )
            connect(progressBar.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            connect(
                progressBar.id,
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM
            )
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
