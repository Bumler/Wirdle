package gameManagement

interface GuessValidator {
    fun validate(guess: String): GuessValidationResult
}