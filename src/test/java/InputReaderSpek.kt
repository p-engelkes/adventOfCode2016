import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

/**
 * Created by pengelkes on 01.12.2016.
 */
class InputReaderSpek : Spek({
    describe("an InputReader") {
        it("should return all lines from the given file") {
            val expected = listOf<String>("1, 2, 3, 4, 5", "6, 7, 8, 9, 10")
            assertEquals(InputReader.getInput("InputReaderTest.txt"), expected);
        }
    }
})