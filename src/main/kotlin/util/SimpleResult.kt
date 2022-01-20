package util

data class SimpleResult private constructor(
    val isSuccess: Boolean,
    val invalidExplanation: String = ""
) {
    companion object {
        fun failure(failureReason: String): SimpleResult {
            return SimpleResult(false, failureReason)
        }

        fun success(): SimpleResult {
            return SimpleResult(true, "")
        }

        fun success(message: String): SimpleResult {
            return SimpleResult(true, message)
        }
    }
}
