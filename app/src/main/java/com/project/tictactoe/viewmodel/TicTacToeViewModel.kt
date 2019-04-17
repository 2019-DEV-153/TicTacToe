package com.project.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {
    var playBoard = Array(3) { IntArray(3) }
    val PLAYER_X = 1
    val PLAYER_O = 2
    var playerTurn = PLAYER_X

    fun recordPlayerMove(position: Int, player: Int): Boolean {
        when (position) {
            position -> if (playBoard[position / 3][position % 3] == 0) {
                playBoard[position / 3][position % 3] = player
                changePlayerTurn(player)
                return true
            }
        }
        return false
    }

    private fun changePlayerTurn(player: Int) {
        if (player == PLAYER_X) {
            playerTurn = PLAYER_O
        } else {
            playerTurn = PLAYER_X
        }
    }

    fun identifyWinnerByRow(): Boolean {
        IntRange(0, 2).forEach { rowPosition ->
            if (playBoard[rowPosition][0] > 0 && playBoard[rowPosition][0] == playBoard[rowPosition][1] && playBoard[rowPosition][0] == playBoard[rowPosition][2]) {
                return true
            }
        }
        return false
    }
}