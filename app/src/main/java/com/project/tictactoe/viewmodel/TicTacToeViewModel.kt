package com.project.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {
    var playBoard = Array(3) { IntArray(3) }
    val PLAYER_X = 1
    val PLAYER_O = 2
    var playerTurn = PLAYER_X
    private var GAME_MOVE_COUNTER = 0

    fun recordPlayerMove(position: Int, player: Int): Boolean {
        when (position) {
            position -> if (playBoard[position / 3][position % 3] == 0) {
                playBoard[position / 3][position % 3] = player
                GAME_MOVE_COUNTER = GAME_MOVE_COUNTER.plus(1)
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

    fun identifyWinnerByColumn(): Boolean {
        IntRange(0, 2).forEach { columnPosition ->
            if (playBoard[0][columnPosition] > 0 && playBoard[0][columnPosition] == playBoard[1][columnPosition] && playBoard[0][columnPosition] == playBoard[2][columnPosition]) {
                return true
            }
        }
        return false
    }

    fun identifyWinnerByDiagonal(): Boolean {
        if (playBoard[0][0] > 0 && playBoard[0][0] == playBoard[1][1] && playBoard[0][0] == playBoard[2][2]) {
                return true
        }else if (playBoard[0][2] > 0 && playBoard[0][2] == playBoard[1][1] && playBoard[0][2] == playBoard[2][0]) {
            return true
        }
        return false
    }

    fun identifyIfMatchDrawn(): Boolean {
        return GAME_MOVE_COUNTER == 9
    }
}