package com.example.bazile.morpion

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity(), View.OnClickListener {

    private var board = mutableMapOf<Int, String>()
    private var Player = true
    private var winner: String = ""
    private var totalBoard = 9
    private val btn = arrayOfNulls<Button>(totalBoard)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFont()
        initButon()
        replay_button.setOnClickListener {
            Toast.makeText(this, "Replay", Toast.LENGTH_LONG).show()
            newGame()
        }


    }

    private fun initButon() {
        for (i in 1..totalBoard) {
            val button = findViewById<Button>(resources.getIdentifier("button$i", "id", packageName))
            button.setOnClickListener(this)
            btn[i - 1] = button
        }
    }

    private fun setFont() {
        val face = Typeface.createFromAsset(assets, "fonts/fipps_regular.otf")
        title_main.typeface = face
        replay_button.typeface = face
    }

    override fun onClick(view: View) {
        val buSelected: Button = view as Button
        var selected = 0
        when (buSelected.id) {
            R.id.button1 -> selected = 1
            R.id.button2 -> selected = 2
            R.id.button3 -> selected = 3
            R.id.button4 -> selected = 4
            R.id.button5 -> selected = 5
            R.id.button6 -> selected = 6
            R.id.button7 -> selected = 7
            R.id.button8 -> selected = 8
            R.id.button9 -> selected = 9
        }
        jouer(selected,buSelected)
        checkWinner()

    }

    private fun checkWinner(): Int {
        if (board.isNotEmpty()) {
            for (combine in combinaison) {
                val (a, b, c) = combine
                if (board[a] != null && board[a] == board[b] && board[a] == board[c] && board[a] == x) {
                    Toast.makeText(this, "Winner 1 ", Toast.LENGTH_LONG).show()
                    this.winner = board.toString()
                    return 10
                }

                if (board[a] != null && board[a] == board[b] && board[a] == board[c] && board[a] == o) {
                    Toast.makeText(this, "Winner 2 ", Toast.LENGTH_LONG).show()
                    this.winner = board.toString()
                    return 10
                }
            }
        }
        return 0
    }

    private fun jouer(selected: Int, buSelected: Button) {
        var cpt = 0
        if (!winner.isEmpty()) {
            Toast.makeText(this, "The game is over", Toast.LENGTH_LONG).show()
            return
        }

        for (i in 1..totalBoard) {
            if (board[i] != null) {
                cpt++
            }
        }
        if (cpt == 8)
            Toast.makeText(this, "Draw ", Toast.LENGTH_LONG).show()


        if (board[selected] != null) {
            Toast.makeText(this, "Don't play ", Toast.LENGTH_LONG).show()
            return
        }
        when {
            Player -> board[selected] = x
            else -> board[selected] = o
        }

        val face = Typeface.createFromAsset(assets, "fonts/fipps_regular.otf")
        buSelected.typeface = face
        buSelected.text = board[selected]
        Player = !Player
    }


    private fun dejouer(selected: Int, buSelected: Button) {

        if (board[selected] == x || board[selected] == o) {
            board[selected] = ""
            buSelected.text = board[selected]
        }
    }


    private fun resetButton() {
        for (i in 1..totalBoard) {
            var button = btn[i - 1]
            button?.text = ""
            button?.isEnabled = true
        }
    }

    private fun newGame() {
        board = mutableMapOf()
        Player = true
        winner = ""
        resetButton()
    }
}
