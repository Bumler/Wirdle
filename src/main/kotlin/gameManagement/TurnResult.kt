package gameManagement

import playerManagement.PlayerData

data class TurnResult (
    val validationResult: GuessValidationResult,
    val gameData: GameData,
    val playerData: PlayerData
)
