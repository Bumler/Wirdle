package gameManagement

import dataLayer.inMemoryRepos.InMemoryWordRepo
import dataLayer.inMemoryRepos.InMemoryWordRepoDataProvider
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EnglishGuessValidatorTest {
    private val expectedLength = 5
    //todo mock this
    private val englishGuessValidator: EnglishGuessValidator = EnglishGuessValidator(expectedLength, InMemoryWordRepo(
        InMemoryWordRepoDataProvider()
    ))
    private val previousGuesses = mutableSetOf<String>()

    @Test
    fun `invalid lengths are invalid`(){
        val testString = "shoe"
        assertFalse { englishGuessValidator.validate(testString, previousGuesses).isSuccess }
    }

    @Test
    fun `can't have symbols`(){
        val testString = "shoe!"
        assertFalse { englishGuessValidator.validate(testString, previousGuesses).isSuccess }
    }

    @Test
    fun `can't have numbers`(){
        val testString = "shoe1"
        assertFalse { englishGuessValidator.validate(testString, previousGuesses).isSuccess }
    }

    @Test
    fun `definitely can't have umlauts`(){
        val testString = "schön"
        assertFalse { englishGuessValidator.validate(testString, previousGuesses).isSuccess }
    }

    @Test
    fun `valid words are valid`(){
        val testString = "cacti"
        assertTrue { englishGuessValidator.validate(testString, previousGuesses).isSuccess }
    }
}