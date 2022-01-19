package gameManagement

import util.SimpleResult

interface GuessValidator {
    fun validate(guess: String): SimpleResult
}