package gameManagement

import wirdleLogic.WirdleResult

class EliminatedLetterBuilder {
    fun getEliminatedLetters(guess: String, guessResult: List<WirdleResult>): Set<Char> {
        val newlyEliminated = mutableSetOf<Char>()
        guessResult.forEachIndexed{
                index, it -> if(it == WirdleResult.WRONG_LETTER) newlyEliminated.add(guess[index])
        }

        return newlyEliminated
    }
}