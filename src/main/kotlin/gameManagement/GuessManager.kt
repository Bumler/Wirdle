package gameManagement

import dataLayer.GameRepo
import wirdleLogic.WirdleChecker

class GuessManager(
    private val wirdleChecker: WirdleChecker,
    private val gameStateJudge: GameStateJudge,
    private val eliminatedLetterBuilder: EliminatedLetterBuilder,
    private val gameRepo: GameRepo
) {
    fun makeAGuess (gameData: GameData, guess: String): GameData {
        val guessResult = wirdleChecker.checkWord(guess, gameData.actualWord)
        val currentTurn = gameData.turnsTaken + 1
        val newGameState = gameStateJudge.determineGameState(guessResult, currentTurn)
        val newlyEliminatedLetters = eliminatedLetterBuilder.getEliminatedLetters(guess, guessResult)

        val updatedGameData = GameData(
            gameData.gameId,
            gameData.wordsGuessed + GuessedWord(guess, guessResult),
            gameData.lettersEliminated + newlyEliminatedLetters,
            currentTurn,
            newGameState,
            gameData.actualWord
        )

        gameRepo.updateGame(updatedGameData)
        return gameData
    }
}