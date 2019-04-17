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
        assertTrue(ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X).first)
    }

    @Test
    fun testShouldReturnFalseIfSelectedPositionHasAlreadyBeenPlayed() {
        assertTrue(ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X).first)
        assertFalse(ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X).first)
    }

    @Test
    fun testShouldReturnTrueIfPlayerTurnHasChangedAfterEachValidMove() {
        assertTrue(ticTacToeViewModel.playerTurn == ticTacToeViewModel.PLAYER_X)
        assertTrue(ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X).first)
        assertTrue(ticTacToeViewModel.playerTurn == ticTacToeViewModel.PLAYER_O)
    }

    @Test
    fun testShouldReturnTrueIfAnyPlayerHaveWonByRow() {
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(3, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(4, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(5, ticTacToeViewModel.PLAYER_X).first)
        assertTrue(ticTacToeViewModel.identifyWinnerByRow())
    }

    @Test
    fun testShouldReturnFalseIfAlternatePlayersHavePlayedConsecutiveBlocksByRow() {
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(0, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_O).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(2, ticTacToeViewModel.PLAYER_X).first)
        assertFalse(ticTacToeViewModel.identifyWinnerByRow())
    }

    @Test
    fun testShouldReturnTrueIfAnyPlayerHaveWonByColumn() {
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(0, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(3, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(6, ticTacToeViewModel.PLAYER_X).first)
        assertTrue(ticTacToeViewModel.identifyWinnerByColumn())
    }

    @Test
    fun testShouldReturnFalseIfAlternatePlayersHavePlayedConsecutiveBlocksByColumn() {
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(4, ticTacToeViewModel.PLAYER_O).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(7, ticTacToeViewModel.PLAYER_X).first)
        assertFalse(ticTacToeViewModel.identifyWinnerByColumn())
    }

    @Test
    fun testShouldReturnTrueIfAnyPlayerHaveWonByDiagonal() {
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(0, ticTacToeViewModel.PLAYER_O).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(4, ticTacToeViewModel.PLAYER_O).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(8, ticTacToeViewModel.PLAYER_O).first)
        assertTrue(ticTacToeViewModel.identifyWinnerByDiagonal())
    }

    @Test
    fun testShouldReturnFalseIfAlternatePlayersHavePlayedConsecutiveBlocksByDiagonal() {
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(2, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(4, ticTacToeViewModel.PLAYER_O).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(6, ticTacToeViewModel.PLAYER_X).first)
        assertFalse(ticTacToeViewModel.identifyWinnerByDiagonal())
    }

    @Test
    fun testShouldReturnTrueIfGameIsFinishedByExhaustingAllMoves() {
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(4, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(0, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(1, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(7, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(6, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(2, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(3, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(5, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(8, ticTacToeViewModel.PLAYER_X).first)
        assertTrue(ticTacToeViewModel.identifyIfMatchDrawn())
    }

    @Test
    fun testShouldReturnFalseIfMovesAreNotAllowedOnceAnyPlayerWins() {
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(2, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(4, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.recordPlayerMove(6, ticTacToeViewModel.PLAYER_X).first)
        assertEquals(true, ticTacToeViewModel.identifyWinnerByDiagonal())
        assertFalse(ticTacToeViewModel.recordPlayerMove(8, ticTacToeViewModel.PLAYER_X).first)
    }
}