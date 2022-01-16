package gameManagement

import java.util.*

class GuessSanitizer {
    fun sanitizeString(s: String): String {
        return s.uppercase(Locale.getDefault()).trim()
    }
}
