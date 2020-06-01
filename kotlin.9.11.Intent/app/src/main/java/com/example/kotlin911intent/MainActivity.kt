package com.example.kotlin911intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        private const val FORM_STATE = "Form state"
    }

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

        val imageLink =
            "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
        Glide.with(this).load(imageLink).into(imageView)

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loginButton.isEnabled = isAuthValid()
            }
        })

        passEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loginButton.isEnabled = isAuthValid()
            }
        })

        checkBox.setOnCheckedChangeListener { _, _ ->
            loginButton.isEnabled = isAuthValid()
        }

        loginButton.setOnClickListener {
            val enabledActivityIntent = Intent(this, EnabledActivity::class.java)
            startActivity(enabledActivityIntent)
        }

    }

    private fun EditText.isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()
    }

    private fun isAuthValid(): Boolean {
        return emailEditText.isEmailValid()
                && emailEditText.text.toString().substringAfter('@') == "gmail.com"
                && passEditText.text.isNotBlank()
                && checkBox.isChecked
    }
}
