/**
 * Created by pengelkes on 02.12.2016.
 */

fun main(args: Array<String>) {
    var startPosition = Position(1, 1)
    InputReader.getInput("Puzzle1.txt").forEach {
        it.forEach {
            startPosition = move(startPosition, Moves.getByString(it))
        }

        print(board[startPosition.y][startPosition.x])
    }
}

fun move(startPosition: Position, move: Moves): Position {
    val newPosition = Position(startPosition.x, startPosition.y)
    newPosition.x += move.x
    newPosition.y += move.y

    if (newPosition.isValid()) {
        return newPosition
    }

    return startPosition
}

val board = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
)

enum class Moves(val x: Int, val y: Int) {
    RIGHT(1, 0),
    LEFT(-1, 0),
    UP(0, -1),
    DOWN(0, 1);

    companion object {
        fun getByString(moveString: Char): Moves {
            when (moveString) {
                'R' -> return RIGHT
                'L' -> return LEFT
                'U' -> return UP
                'D' -> return DOWN
            }

            return RIGHT
        }
    }
}

data class Position(var x: Int, var y: Int) {

    fun isValid(): Boolean {
        if ((x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {
            return true
        }

        return false
    }
}

