package com.example.kotlin911intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enabled.*

class EnabledActivity : AppCompatActivity() {

    companion object {
        private const val DIAL_REQUEST_CODE = 100
    }

    //Do not work with alpha05, do not have dial method
    private val dialLauncher = prepareCall(ActivityResultContracts.Dial()) { result ->
        //    Did not answer with "We called"
        if (result) {
            println(result.toString())
            toast("We did call")
        } else {
            println(result.toString())
            toast("We did not call")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enabled)

        callButton.setOnClickListener {
            val phoneNumber = phoneNumberEditText.text.toString()
            val isPhoneNumberValid = Patterns.PHONE.matcher(phoneNumber).matches()
            if (!isPhoneNumberValid) {
                toast("Type valid phone number")
            } else {
                dialLauncher.launch(phoneNumber)
//                val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
//                    data = Uri.parse("tel:$phoneNumber")
//                }
//                if (phoneIntent.resolveActivity(packageManager) != null) {
//                    startActivityForResult(phoneIntent, DIAL_REQUEST_CODE)
//                }
            }
        }
    }
//    Did not answer with "We called"
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == DIAL_REQUEST_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//                toast("We did call")
//            } else {
//                toast("We did not call")
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}