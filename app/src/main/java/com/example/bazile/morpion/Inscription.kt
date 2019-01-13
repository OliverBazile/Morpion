package com.example.bazile.morpion

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern

class Inscription : AppCompatActivity() {

    private lateinit var textTitle: TextView
    private lateinit var textGoogle: TextView
    private lateinit var editMail: EditText
    private lateinit var editPassword :EditText
    private lateinit var buttonValider: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)

        textTitle = findViewById<View>(R.id.title) as TextView
        editMail = findViewById<View>(R.id.edit_text) as EditText
        editPassword = findViewById<View>(R.id.edit_text_password) as EditText
        buttonValider = findViewById<View>(R.id.valider) as Button

        setFont()
        valider()
    }


    private fun setFont(){
        val face = Typeface.createFromAsset(assets, "fonts/fipps_regular.otf")
        textTitle.typeface=face
        buttonValider.typeface= face
        editPassword.typeface = face
        editMail.typeface= face
    }

    private fun checkMail():Boolean{
        return !editMail.text.isEmpty() && isEmailValid(editMail.text.toString())
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
        return !editPassword.text.isEmpty() && editPassword.text.length >=6
    }

    @SuppressLint("ShowToast")
    private fun valider(){

        buttonValider.setOnClickListener {
            if (checkMail() && checkpassword())
                Toast.makeText(this, "Le mail correct and password", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Veilliez mettre un mail correct et un password de 6 mots", Toast.LENGTH_LONG).show()
        }
    }
}