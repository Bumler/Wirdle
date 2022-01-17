package gameManagement

import dataLayer.GameRepo
import dataLayer.PlayerRepo
import playerManagement.PlayerData
import java.util.*

class GameRetriever(
    private val gameRepo: GameRepo,
    private val playerRepo: PlayerRepo
) {
    fun retrieveGameForPlayer(playerData: PlayerData): GameData?{
        if (playerData.gameInProgress == null)
            return null

        val gameData = gameRepo.getGame(playerData.playerId)

        if (gameData == null){
            removeFaultyGameFromPlayer(playerData, playerData.gameInProgress)
        }

        return gameData
    }

    private fun removeFaultyGameFromPlayer(playerData: PlayerData, gameInProgress: UUID) {
        val updatedPlayerData = PlayerData(
            playerData.playerId,
            null,
            playerData.wins,
            playerData.totalGamesPlayed,
            playerData.previousGames + gameInProgress,
            playerData.turnCompleted
        )
        playerRepo.updatePlayer(updatedPlayerData)
    }
}