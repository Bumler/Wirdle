package gameManagement

//Todo this should also check for if a word is real or not.
class EnglishGuessValidator(
    private val expectedWordLength: Int
): GuessValidator {
    private val alphaRegex: Regex = Regex("^[a-zA-Z]*\$")

    override fun validate(guess: String): GuessValidationResult {
        if(guess.length != expectedWordLength){
            return GuessValidationResult.failure("Expected word length is $expectedWordLength. Your word is $expectedWordLength")
        }
        if(!alphaRegex.matches(guess)){
            return GuessValidationResult.failure("Your word must be 5 letters and be only composed of characters between A-Z (it's case-insensitive so don't worry about that).")
        }

        return GuessValidationResult.success()
    }

}