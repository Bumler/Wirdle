package playerManagement

import java.util.*

data class PlayerData (
    val playerId: UUID,
    val gameInProgress: UUID?,
    val wins: Int,
    val totalGamesPlayed: Int,
    val previousGames: List<UUID>,
    val turnCompleted: List<Int>
)