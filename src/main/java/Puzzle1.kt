/**
 * Created by Pattis-PC on 03.12.2016.
 */
fun main(args: Array<String>) {
    val trianglesString = InputReader.getInput("Puzzle1.txt")
    var validTriangles = 0
    trianglesString.forEach {
        if (Triangle(it).isValid()) {
            validTriangles++
        }
    }

    println(validTriangles)
}

class Triangle(triangle: String) {
    var a: Int
    var b: Int
    var c: Int

    init {
        val triangleWithEmptyStrings = triangle.split(" ")
        val triangleSides = triangleWithEmptyStrings.filter { !it.isEmpty() }
        this.a = Integer.valueOf(triangleSides[0].trim())
        this.b = Integer.valueOf(triangleSides[1].trim())
        this.c = Integer.valueOf(triangleSides[2].trim())
    }

    fun isValid(): Boolean {
        if (a + b > c && b + c > a && a + c > b) {
            return true
        }

        return false
    }
}