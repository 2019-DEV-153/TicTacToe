package com.project.tictactoe.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.project.tictactoe.R
import com.project.tictactoe.viewmodel.TicTacToeViewModel
import kotlinx.android.synthetic.main.activity_tictactoe.*

class TicTacToeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var ticTacToeViewModel: TicTacToeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)

        ticTacToeViewModel = TicTacToeViewModel()

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

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn1 -> checkAndRecordPlayerMove(btn1)
            R.id.btn2 -> checkAndRecordPlayerMove(btn2)
            R.id.btn3 -> checkAndRecordPlayerMove(btn3)
            R.id.btn4 -> checkAndRecordPlayerMove(btn4)
            R.id.btn5 -> checkAndRecordPlayerMove(btn5)
            R.id.btn6 -> checkAndRecordPlayerMove(btn6)
            R.id.btn7 -> checkAndRecordPlayerMove(btn7)
            R.id.btn8 -> checkAndRecordPlayerMove(btn8)
            R.id.btn9 -> checkAndRecordPlayerMove(btn9)
        }
    }

    private fun checkAndRecordPlayerMove(view: Button) {
        if (ticTacToeViewModel.playerTurn == ticTacToeViewModel.PLAYER_X) {
            val isValidMove =
                ticTacToeViewModel.recordPlayerMove(view.tag.toString().toInt(), ticTacToeViewModel.PLAYER_X)
            if (isValidMove.first) {
                view.text = getString(R.string.player_x)
            } else{
                Toast.makeText(this, isValidMove.second, Toast.LENGTH_SHORT).show()
            }
        } else {
            val isValidMove =
                ticTacToeViewModel.recordPlayerMove(view.tag.toString().toInt(), ticTacToeViewModel.PLAYER_O)
            if (isValidMove.first) {
                view.text = getString(R.string.player_o)
            } else{
                Toast.makeText(this, isValidMove.second, Toast.LENGTH_SHORT).show()
            }
        }
        identifyIfAnyPlayerHadWon()
    }

    private fun identifyIfAnyPlayerHadWon() {
        val horizontalPair = ticTacToeViewModel.identifyWinnerByColumn()
        val verticalPair = ticTacToeViewModel.identifyWinnerByRow()
        val diagonalPair = ticTacToeViewModel.identifyWinnerByDiagonal()
        val drawnMatch = ticTacToeViewModel.identifyIfMatchDrawn()

        if (horizontalPair) {
            game_result.text = getString(R.string.message_match_won)
        } else if (verticalPair) {
            game_result.text = getString(R.string.message_match_won)
        } else if (diagonalPair) {
            game_result.text = getString(R.string.message_match_won)
        } else if (drawnMatch) {
            game_result.text = getString(R.string.message_match_drawn)
        }
    }
}
