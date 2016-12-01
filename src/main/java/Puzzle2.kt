import java.util.*

fun main(args: Array<String>) {
    println(getDistanceToNewHeadQuarter(InputReader.getInput("Puzzle1.txt")[0]))
}

fun getDistanceToNewHeadQuarter(instructionString: String): Int {
    val startPosition = Position(0, 0, Facing.NORTH)
    val instructions = getInstructions(instructionString)
    val finalPosition = followInstructionsAndReturnFirstVisitedPositionTwice(startPosition, instructions)

    return calculateDistanceFromStartPosition(startPosition, finalPosition)
}

/**
 * Created by pengelkes on 01.12.2016.
 */
fun followInstructionsAndReturnFirstVisitedPositionTwice(startPosition: Position, instructionList: List<Instruction>): Position {
    val visitedPositions = DoublePositionList()
    val finalPosition = Position(startPosition.x, startPosition.y, startPosition.facing)
    instructionList.forEach test@ {
        when (finalPosition.facing) {
            Facing.NORTH -> {
                when (it.direction) {
                    Direction.RIGHT -> {
                        for (i in 1..it.amountOfSteps) {
                            visitedPositions.add(Position(finalPosition.x + 1, finalPosition.y, Facing.NORTH))
                            finalPosition.x += 1
                        }

                        finalPosition.facing = Facing.EAST
                    }
                    Direction.LEFT -> {
                        for (i in 1..it.amountOfSteps) {
                            visitedPositions.add(Position(finalPosition.x - 1, finalPosition.y, Facing.NORTH))
                            finalPosition.x -= 1
                        }
                        finalPosition.facing = Facing.WEST
                    }
                }
            }
            Facing.EAST -> {
                when (it.direction) {
                    Direction.RIGHT -> {
                        for (i in 1..it.amountOfSteps) {
                            visitedPositions.add(Position(finalPosition.x, finalPosition.y - 1, Facing.NORTH))
                            finalPosition.y -= 1
                        }
                        finalPosition.facing = Facing.SOUTH
                    }
                    Direction.LEFT -> {
                        for (i in 1..it.amountOfSteps) {
                            visitedPositions.add(Position(finalPosition.x, finalPosition.y + 1, Facing.NORTH))
                            finalPosition.y += 1
                        }
                        finalPosition.facing = Facing.NORTH
                    }
                }
            }
            Facing.SOUTH -> {
                when (it.direction) {
                    Direction.RIGHT -> {
                        for (i in 1..it.amountOfSteps) {
                            visitedPositions.add(Position(finalPosition.x - 1, finalPosition.y, Facing.NORTH))
                            finalPosition.x -= 1
                        }
                        finalPosition.facing = Facing.WEST
                    }
                    Direction.LEFT -> {
                        for (i in 1..it.amountOfSteps) {
                            visitedPositions.add(Position(finalPosition.x + 1, finalPosition.y, Facing.NORTH))
                            finalPosition.x += 1
                        }
                        finalPosition.facing = Facing.EAST
                    }
                }
            }
            Facing.WEST -> {
                when (it.direction) {
                    Direction.RIGHT -> {
                        for (i in 1..it.amountOfSteps) {
                            visitedPositions.add(Position(finalPosition.x, finalPosition.y + 1, Facing.NORTH))
                            finalPosition.y += 1
                        }
                        finalPosition.facing = Facing.NORTH
                    }
                    Direction.LEFT -> {
                        for (i in 1..it.amountOfSteps) {
                            visitedPositions.add(Position(finalPosition.x, finalPosition.y - 1, Facing.NORTH))
                            finalPosition.y -= 1
                        }
                        finalPosition.facing = Facing.SOUTH
                    }
                }
            }
        }

        visitedPositions.firstDoublePosition?.let {
            return it
        }
    }

    return finalPosition
}

class DoublePositionList(var firstDoublePosition: Position? = null) : ArrayList<Position>() {
    override fun add(element: Position): Boolean {
        if (contains(element) && firstDoublePosition == null) {
            firstDoublePosition = element
        }
        return super.add(element)
    }
}