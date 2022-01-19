package playerManagement

import java.util.*

data class PlayerData (
    val playerId: UUID,
    val gameInProgress: UUID?,
    val previousGames: List<GameResult>
)