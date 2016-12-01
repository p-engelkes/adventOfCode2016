/**
 * Created by pengelkes on 01.12.2016.
 */
fun main(args: Array<String>) {
    println(getDistanceToHeadQuarter(InputReader.getInput("Puzzle1.txt")[0]))
}

fun getDistanceToHeadQuarter(instructionString: String): Int {
    val startPosition = Position(0, 0, Facing.NORTH)
    val instructions = getInstructions(instructionString)
    val finalPosition = followInstructions(startPosition, instructions)

    return calculateDistanceFromStartPosition(startPosition, finalPosition)
}

fun calculateDistanceFromStartPosition(startPosition: Position, finalPosition: Position): Int {
    var xDifference = startPosition.x - finalPosition.x
    var yDifference = startPosition.y - finalPosition.y

    if (xDifference < 0) {
        xDifference *= -1
    }

    if (yDifference < 0) {
        yDifference *= -1
    }

    return xDifference + yDifference
}

fun followInstructions(startPosition: Position, instructionList: List<Instruction>): Position {
    val finalPosition = Position(startPosition.x, startPosition.y, startPosition.facing)
    instructionList.forEach {
        when (finalPosition.facing) {
            Facing.NORTH -> {
                when (it.direction) {
                    Direction.RIGHT -> {
                        finalPosition.x += it.amountOfSteps
                        finalPosition.facing = Facing.EAST
                    }
                    Direction.LEFT -> {
                        finalPosition.x -= it.amountOfSteps
                        finalPosition.facing = Facing.WEST
                    }
                }
            }
            Facing.EAST -> {
                when (it.direction) {
                    Direction.RIGHT -> {
                        finalPosition.y -= it.amountOfSteps
                        finalPosition.facing = Facing.SOUTH
                    }
                    Direction.LEFT -> {
                        finalPosition.y += it.amountOfSteps
                        finalPosition.facing = Facing.NORTH
                    }
                }
            }
            Facing.SOUTH -> {
                when (it.direction) {
                    Direction.RIGHT -> {
                        finalPosition.x -= it.amountOfSteps
                        finalPosition.facing = Facing.WEST
                    }
                    Direction.LEFT -> {
                        finalPosition.x += it.amountOfSteps
                        finalPosition.facing = Facing.EAST
                    }
                }
            }
            Facing.WEST -> {
                when (it.direction) {
                    Direction.RIGHT -> {
                        finalPosition.y += it.amountOfSteps
                        finalPosition.facing = Facing.NORTH
                    }
                    Direction.LEFT -> {
                        finalPosition.y -= it.amountOfSteps
                        finalPosition.facing = Facing.SOUTH
                    }
                }
            }
        }
    }

    return finalPosition
}

fun getInstructions(instructionString: String): List<Instruction> {
    val instructions = mutableListOf<Instruction>()
    val instructionsList = instructionString.replace(" ", "").split(",")
    instructionsList.forEach {
        val direction = Direction.getDirectionByString(it[0])
        val amountOfSteps = Integer.valueOf(it.substring(1, it.length))
        instructions.add(Instruction(direction, amountOfSteps))
    }

    return instructions
}

data class Instruction(var direction: Direction, var amountOfSteps: Int)

data class Position(var x: Int, var y: Int, var facing: Facing)

enum class Facing {
    NORTH,
    EAST,
    SOUTH,
    WEST
}

enum class Direction(val direction: String) {
    RIGHT("R"),
    LEFT("L");

    companion object {
        fun getDirectionByString(direction: Char): Direction {
            when (direction) {
                'R' -> return RIGHT
                'L' -> return LEFT
                else -> return RIGHT
            }
        }
    }
}