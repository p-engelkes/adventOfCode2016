/**
 * Created by pengelkes on 06.12.2016.
 */
fun main(args: Array<String>) {
    val trianglesString = InputReader.getInput("Puzzle1.txt")
    var validTriangles = 0
    val triangles = mutableListOf<Triangle>()
    val horizontalTriangles = mutableListOf<Triangle>()
    trianglesString.forEach {
        triangles.add(Triangle(it))
    }
    for (i in 0..triangles.size - 1 step 3) {
        val firstTriangle = triangles[i]
        val secondTriangle = triangles[i + 1]
        val thirdTriangle = triangles[i + 2]

        horizontalTriangles.add(Triangle(firstTriangle.a, secondTriangle.a, thirdTriangle.a))
        horizontalTriangles.add(Triangle(firstTriangle.b, secondTriangle.b, thirdTriangle.b))
        horizontalTriangles.add(Triangle(firstTriangle.c, secondTriangle.c, thirdTriangle.c))
    }
    horizontalTriangles.forEach {
        if (it.isValid()) {
            validTriangles++
        }
    }

    println(validTriangles)
}