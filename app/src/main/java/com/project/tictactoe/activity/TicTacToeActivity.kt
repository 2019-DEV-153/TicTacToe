package com.project.tictactoe.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.project.tictactoe.R
import kotlinx.android.synthetic.main.activity_tictactoe.*

class TicTacToeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)

        btn1.setOnClickListener(this)
        btn1.tag = 0
        btn2.setOnClickListener(this)
        btn2.tag = 1
        btn3.setOnClickListener(this)
        btn3.tag = 2
        btn4.setOnClickListener(this)
        btn4.tag = 3
        btn5.setOnClickListener(this)
        btn5.tag = 4
        btn6.setOnClickListener(this)
        btn6.tag = 5
        btn7.setOnClickListener(this)
        btn7.tag = 6
        btn8.setOnClickListener(this)
        btn8.tag = 7
        btn9.setOnClickListener(this)
        btn9.tag = 8
    }

    override fun onClick(p0: View?) {

    }
}
