package gameManagement

data class GuessValidationResult private constructor(
    val isValid: Boolean,
    val invalidExplanation: String = ""
) {
    companion object {
        fun failure(failureReason: String): GuessValidationResult {
            return GuessValidationResult(false, failureReason)
        }

        fun success(): GuessValidationResult {
            return GuessValidationResult(true, "")
        }
    }
}
