package commandLayer

import gameManagement.TurnResult

class TurnResultMessageDecorator {
    fun formatMessage(turnResult: TurnResult): String{
        throw NotImplementedError()
    }
}