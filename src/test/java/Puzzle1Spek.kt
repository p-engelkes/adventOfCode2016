import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

/**
 * Created by pengelkes on 01.12.2016.
 */
class Puzzle1Spek : Spek({
    given("an instruction string") {
        it("should return a list of all instructions") {
            var expected = listOf<Instruction>(Instruction(Direction.RIGHT, 2), Instruction(Direction.LEFT, 3))
            assertEquals(expected, getInstructions("R2, L3"))

            expected = listOf<Instruction>(Instruction(Direction.RIGHT, 10),
                    Instruction(Direction.LEFT, 190),
                    Instruction(Direction.RIGHT, 5)
            )
            assertEquals(expected, getInstructions("R10, L190, R5"))
        }
    }

    given("a list of instructions") {
        it("should return the desired target position") {
            val expected = Position(2, 3, Facing.NORTH)
            val instructions = listOf<Instruction>(Instruction(Direction.RIGHT, 2), Instruction(Direction.LEFT, 3))
            val startPosition = Position(0, 0, Facing.NORTH)

            assertEquals(expected, followInstructions(startPosition, instructions))
        }
    }

    given("a start and end position") {
        it("should return the distance between the positions") {
            val expected = 5
            val startPosition = Position(0, 0, Facing.NORTH)
            val finalPosition = Position(2, 3, Facing.NORTH)

            assertEquals(expected, calculateDistanceFromStartPosition(startPosition, finalPosition))
        }
    }

    given("an instruction string") {
        it("should return the correct distance between the start and final position") {
            var expected = 5
            assertEquals(expected, getDistanceToHeadQuarter("R2, L3"))

            expected = 2
            assertEquals(expected, getDistanceToHeadQuarter("R2, R2, R2"))

            expected = 12
            assertEquals(expected, getDistanceToHeadQuarter("R5, L5, R5, R3"))

            expected = 4
            assertEquals(expected, getDistanceToHeadQuarter("R1, R1, R3, R1, R1, L2, R5, L2, R5, R1, R4, L2, R3, L3, R4"))

            expected = 10
            assertEquals(expected, getDistanceToHeadQuarter("R1, R1, R3, R1, R1, L2, R5, L2, R5, R1, R4, L2, R3, L3, R4, L5, R4, R4, R1, L5, L4, R5, R3, L1, R4, R3, L2, L1, R3, L4"))
        }
    }
})