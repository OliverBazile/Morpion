package com.example.bazile.morpion

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_title.*

@SuppressLint("Registered")
class TitleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)
        setFont()
        onclick()
    }
    private fun setFont(){
        val face = Typeface.createFromAsset(assets, "fonts/fipps_regular.otf")
        multi_player.typeface=face
        single_player.typeface=face
        title_lead.typeface=face
    }

    private fun onclick(){
        single_player.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        multi_player.setOnClickListener{
            val intent = Intent(this,Inscription::class.java)
            startActivity(intent)
        }
    }
}