package dataLayer

import java.util.*

interface WordRepo {
    fun getNewWord(wordsUsed: Set<UUID>): Word
}
