package com.project.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {
    var playBoard = Array(3) { IntArray(3) }
    val PLAYER_X = 1
    val PLAYER_O = 2
    var playerTurn = PLAYER_X

    fun recordPlayerMove(position: Int, player: Int): Boolean {
        when (position) {
            position -> playBoard[position / 3][position % 3] = player
        }
        return true
    }
}