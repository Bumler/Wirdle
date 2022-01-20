import wirdleLogic.WirdleChecker
import wirdleLogic.WirdleResult
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WirdleCheckerTest {
    private val wirdleChecker: WirdleChecker = WirdleChecker()

    @Test
    fun `perfect match`(){
        val res = wirdleChecker.checkWord("henry", "henry")
        val expected = listOf(WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH)

        assertEquals(expected, res)
    }

    @Test
    fun `partial match`(){
        val res = wirdleChecker.checkWord("henry", "herny")
        val expected = listOf(WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.HAS_LETTER, WirdleResult.HAS_LETTER, WirdleResult.EXACT_MATCH)

        assertEquals(expected, res)
    }

    @Test
    fun `mixed casing perfect match`(){
        val res = wirdleChecker.checkWord("HENRY", "henry")
        val expected = listOf(WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH)

        assertEquals(expected, res)
    }

    @Test //It's a different responsibility to check for this
    fun `different lengths don't throw`(){
        val res = wirdleChecker.checkWord("henr", "henry")
        val expected = listOf(WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH, WirdleResult.EXACT_MATCH)

        assertEquals(expected, res)
    }

    @Test
    fun `no matches`(){
        val res = wirdleChecker.checkWord("cacti", "henry")
        val expected = listOf(WirdleResult.WRONG_LETTER, WirdleResult.WRONG_LETTER, WirdleResult.WRONG_LETTER, WirdleResult.WRONG_LETTER, WirdleResult.WRONG_LETTER)

        assertEquals(expected, res)
    }

    @Test
    fun `double letters in actual`(){
        val res = wirdleChecker.checkWord("combs", "cacti")
        val expected = listOf(WirdleResult.EXACT_MATCH, WirdleResult.WRONG_LETTER, WirdleResult.WRONG_LETTER, WirdleResult.WRONG_LETTER, WirdleResult.WRONG_LETTER)

        assertEquals(expected, res)
    }

    @Test
    fun `double letters in guess`(){
        val res = wirdleChecker.checkWord("cacti", "combs")
        val expected = listOf(WirdleResult.EXACT_MATCH, WirdleResult.WRONG_LETTER, WirdleResult.HAS_LETTER, WirdleResult.WRONG_LETTER, WirdleResult.WRONG_LETTER)

        assertEquals(expected, res)
    }
}