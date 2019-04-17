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
}