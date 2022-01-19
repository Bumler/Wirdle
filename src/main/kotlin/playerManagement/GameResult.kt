package playerManagement

import java.time.LocalDateTime
import java.util.*

data class GameResult(
    val gameId: UUID,
    val turnComplete: Int,
    val isWin: Boolean,
    val isError: Boolean,
    val completeDate: LocalDateTime
) {
    companion object {
        fun win(gameId: UUID, turnComplete: Int): GameResult{
            return GameResult(
                gameId,
                turnComplete,
                isWin = true,
                isError =  false,
                LocalDateTime.now()
            )
        }

        fun lose(gameId: UUID): GameResult{
            return GameResult(
                gameId,
                -1,
                isWin = false,
                isError =  false,
                LocalDateTime.now()
            )
        }

        fun error(gameId: UUID): GameResult{
            return GameResult(
                gameId,
                -1,
                isWin = false,
                isError =  true,
                LocalDateTime.now()
            )
        }
    }
}