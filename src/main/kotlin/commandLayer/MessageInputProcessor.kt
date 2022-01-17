package commandLayer

import dataLayer.PlayerRepo
import gameManagement.GameRetriever
import gameManagement.TurnManager
import playerManagement.PlayerData
import java.util.*

class MessageInputProcessor(
    private val playerRepo: PlayerRepo,
    private val gameRetriever: GameRetriever,
    private val turnManager: TurnManager,
    private val turnResultMessageDecorator: TurnResultMessageDecorator
) {
    fun processCommand(inputString: String, playerId: UUID): MessageResponse {
        val playerData = playerRepo.getPlayer(playerId) ?: playerRepo.createPlayer(playerId)

        return tryRunCommand(inputString, playerData) ?:
            tryToTakeATurn(inputString, playerData) ?:
            MessageResponse("Bad input", true)
    }

    private fun tryRunCommand(inputString: String, playerData: PlayerData): MessageResponse? {
        throw NotImplementedError()
    }

    private fun tryToTakeATurn(inputString: String, playerData: PlayerData): MessageResponse? {
        val gameData = gameRetriever.retrieveGameForPlayer(playerData) ?: return null

        val turnResult = turnManager.takeATurn(playerData, gameData, inputString)
        return if (turnResult.validationResult.isValid)
            MessageResponse(turnResultMessageDecorator.formatMessage(turnResult), false)
            else MessageResponse(turnResult.validationResult.invalidExplanation, true)
    }
}