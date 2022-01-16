package gameManagement

import java.util.*

data class GameData(
    val gameId: UUID,
    val wordsGuessed: List<GuessedWord>,
    val lettersEliminated: Set<Char>,
    val turnsTaken: Int,
    val gameState: GameState,
    val actualWord: String
){
    companion object {
        fun create(actualWord: String): GameData{
            return GameData(
                UUID.randomUUID(),
                listOf(),
                setOf(),
                0,
                GameState.IN_PROGRESS,
                actualWord
            )
        }
    }
}
