package com.example.bazile.morpion.game

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bazile.morpion.R
import kotlinx.android.synthetic.main.activity_title.*

@SuppressLint("Registered")
class TitleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title)
        onclick()
    }

    private fun onclick() {
        single_player.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        multi_player.setOnClickListener {
            val intent = Intent(this, Inscription::class.java)
            startActivity(intent)
        }
    }
}