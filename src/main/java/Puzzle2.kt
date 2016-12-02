/**
 * Created by pengelkes on 02.12.2016.
 */

fun main(args: Array<String>) {
    var startPosition = Position(2, 0)
    InputReader.getInput("Puzzle1.txt").forEach {
        it.forEach {
            startPosition = movePuzzle2(startPosition, Moves.getByChar(it))
        }

        print(boardPuzzle2[startPosition.x][startPosition.y])
    }
}

fun movePuzzle2(startPosition: Position, move: Moves): Position {
    val newPosition = Position(startPosition.x, startPosition.y)
    newPosition.x += move.x
    newPosition.y += move.y

    if (newPosition.isValidPuzzle2()) {
        return newPosition
    }

    return startPosition
}

val boardPuzzle2 = arrayOf(
        arrayOf(-1, -1, 1, -1, -1),
        arrayOf(-1, 2, 3, 4, -1),
        arrayOf(5, 6, 7, 8, 9),
        arrayOf(-1, 'A', 'B', 'C', -1),
        arrayOf(-1, -1, 'D', -1, -1)
)

