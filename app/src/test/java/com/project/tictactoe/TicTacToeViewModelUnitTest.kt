package com.project.tictactoe

import com.project.tictactoe.viewmodel.TicTacToeViewModel
import org.junit.Test

import org.junit.Assert.*

class TicTacToeViewModelUnitTest {
    private var ticTacToeViewModel = TicTacToeViewModel()

    @Test
    fun testShouldReturnTrueIfAllMovesAreLegalOnInitial() {
        for (i in 0..2) {
            for (j in 0..2) {
                assertTrue(ticTacToeViewModel.playBoard[i][j] == 0)
            }
        }
    }

    @Test
    fun testShouldReturnTrueIfFirstMoveIsByX() {
        assertTrue(ticTacToeViewModel.playerTurn == ticTacToeViewModel.PLAYER_X)
    }

    @Test
    fun testShouldReturnTrueIfPlayerMoveIsValid() {
        assertTrue(ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X))
    }

    @Test
    fun testShouldReturnFalseIfSelectedPositionHasAlreadyBeenPlayed() {
        assertTrue(ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X))
        assertFalse(ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X))
    }
}