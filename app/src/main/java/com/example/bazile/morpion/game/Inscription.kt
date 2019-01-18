package com.example.bazile.morpion.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.bazile.morpion.R
import kotlinx.android.synthetic.main.activity_inscription.*
import java.util.regex.Pattern

class Inscription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)
        valider()
    }

    private fun checkMail():Boolean{
        return !edit_text_email.text.isEmpty() && isEmailValid(edit_text_email.text.toString())
    }

    private fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    private fun checkpassword():Boolean{
        return !edit_text_password.text.isEmpty() && edit_text_password.text.length >=6
    }

    @SuppressLint("ShowToast")
    private fun valider(){

        valider.setOnClickListener {
            if (checkMail() && checkpassword())
                Toast.makeText(this, "Le mail correct and password", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Veilliez mettre un mail correct et un password de 6 mots", Toast.LENGTH_LONG).show()
        }
    }
}