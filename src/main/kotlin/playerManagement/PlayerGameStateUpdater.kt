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
        val result = if (isWin) GameResult.win(gameData.gameId, gameData.turnsTaken)
            else GameResult.lose(gameData.gameId)

        val updatedPlayerInfo = PlayerData(
            playerData.playerId,
            null,
            playerData.previousGames + result
        )

        playerRepo.updatePlayer(updatedPlayerInfo)
        return playerData
    }
}