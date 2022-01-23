package dataLayer.inMemoryRepos

import dataLayer.Word
import dataLayer.WordRepo
import java.util.*

class InMemoryWordRepo : WordRepo {
    override fun getNewWord(wordsUsed: Set<UUID>): Word {
        return Word(UUID.randomUUID(), "BIRDS")
    }
}