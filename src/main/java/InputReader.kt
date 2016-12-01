import java.io.File

/**
 * Created by pengelkes on 01.12.2016.
 */
class InputReader {
    companion object {
        fun getInput(fileName: String): List<String> {
            val file = File(InputReader::class.java.classLoader.getResource(fileName).file)
            return file.readLines()
        }
    }
}