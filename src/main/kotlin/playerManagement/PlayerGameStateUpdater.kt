package playerManagement

import dataLayer.PlayerRepo
import gameManagement.GameData
import gameManagement.GameState

class PlayerGameStateUpdater(
    private val playerRepo: PlayerRepo
) {
    fun update(playerData: PlayerData, gameData: GameData): PlayerData{
        if (gameData.gameState == GameState.IN_PROGRESS)
            return playerData

        val isWin = gameData.gameState == GameState.WON
        val updatedWins = if (isWin) playerData.wins + 1 else playerData.wins
        val updatedTurnCompleted = if (isWin) playerData.turnCompleted + gameData.turnsTaken
            else playerData.turnCompleted

        val updatedPlayerInfo = PlayerData(
            playerData.playerId,
            null,
            updatedWins,
            playerData.totalGamesPlayed + 1,
            playerData.previousGames + gameData.gameId,
            updatedTurnCompleted
        )

        playerRepo.updatePlayer(updatedPlayerInfo)
        return playerData
    }
}