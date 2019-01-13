package com.example.bazile.morpion

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast

@SuppressLint("Registered")
class TitleActivity : AppCompatActivity() {

    internal lateinit var text: TextView
    private lateinit var textSinglePlayer: TextView
    private lateinit var textMultiPlayer: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)

        text = findViewById<View>(R.id.title) as TextView
        textMultiPlayer = findViewById<View>(R.id.multi_player) as TextView
        textSinglePlayer = findViewById<View>(R.id.single_player) as TextView

        setFont()
        onclick()
    }
    private fun setFont(){
        val face = Typeface.createFromAsset(assets, "fonts/fipps_regular.otf")
        textMultiPlayer.typeface=face
        text.typeface=face
        textSinglePlayer.typeface=face
    }

    private fun onclick(){
        textSinglePlayer.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        textMultiPlayer.setOnClickListener{
            val intent = Intent(this,Inscription::class.java)
            startActivity(intent)
        }
    }
}