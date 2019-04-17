package com.project.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {
    var playBoard = Array(3) { IntArray(3) }
    val PLAYER_X = 1
    val PLAYER_O = 2
    var playerTurn = PLAYER_X
    private var GAME_MOVE_COUNTER = 0
    var isGameFinished: Boolean = false

    fun recordPlayerMove(position: Int, player: Int): Boolean {
        if (!isGameFinished && GAME_MOVE_COUNTER <= 9) {
            when (position) {
                position -> if (playBoard[position / 3][position % 3] == 0) {
                    playBoard[position / 3][position % 3] = player
                    GAME_MOVE_COUNTER = GAME_MOVE_COUNTER.plus(1)
                    changePlayerTurn(player)
                    return true
                }
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
            if (playBoard[rowPosition][0] > 0 && compareUserMove(Pair(rowPosition, 0), Pair(rowPosition, 1)) &&
                compareUserMove(Pair(rowPosition, 0), Pair(rowPosition, 2))) {
                isGameFinished = true
                return true
            }
        }
        return false
    }

    fun identifyWinnerByColumn(): Boolean {
        IntRange(0, 2).forEach { columnPosition ->
            if (playBoard[0][columnPosition] > 0 && compareUserMove(Pair(0, columnPosition), Pair(1, columnPosition))
                && compareUserMove(Pair(0, columnPosition), Pair(2, columnPosition))) {
                isGameFinished = true
                return true
            }
        }
        return false
    }

    fun identifyWinnerByDiagonal(): Boolean {
        if (playBoard[0][0] > 0 && compareUserMove(Pair(0, 0), Pair(1, 1)) && compareUserMove(Pair(0, 0), Pair(2, 2))) {
            isGameFinished = true
            return true
        } else if (playBoard[0][2] > 0 && compareUserMove(Pair(0, 2), Pair(1, 1)) &&
            compareUserMove(Pair(0, 2), Pair(2, 0))) {
            isGameFinished = true
            return true
        }
        return false
    }

    fun identifyIfMatchDrawn(): Boolean {
        if (GAME_MOVE_COUNTER == 9) {
            isGameFinished = true
            return true
        } else {
            return false
        }
    }

    private fun compareUserMove(firstPosition: Pair<Int, Int>, secondPosition: Pair<Int, Int>): Boolean {
        return playBoard[firstPosition.first][firstPosition.second] == playBoard[secondPosition.first][secondPosition.second]
    }
}