package software.steinhauer.interviews.ee

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import software.steinhauer.interviews.ee.Directions.*
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class RoverTest {

    private val centeredHeadingNorth: Location = Location(0, 0, NORTH)
    private val centeredHeadingSouth: Location = Location(0, 0, SOUTH)
    private val centeredHeadingEast: Location = Location(0, 0, EAST)
    private val centeredHeadingWest: Location = Location(0, 0, WEST)
    private val middleFarNorthHeadingNorth: Location = Location(0, 10, NORTH)
    private val middleFarSouthHeadingSouth: Location = Location(0, -10, SOUTH)
    private val middleFarEastHeadingEast: Location = Location(10, 0, EAST)
    private val middleFarWestHeadingWest: Location = Location(-10, 0, WEST)

    @Nested
    @DisplayName("Given the rover initially is heading EAST")
    inner class GivenInitialHeadingIsEast {
        @Test
        fun `When position is in the center and move is called once Then it should be at (1, 0, EAST)`() =
            executeRoverMove(centeredHeadingEast, Location(1, 0, EAST))

        @Test
        fun `When position is in the far east and move is called 3 times Then it should be at (-8, 0, EAST)`() =
            executeRoverMove(
                initialPosition = middleFarEastHeadingEast,
                numberOfMoves = 3,
                expectedLocation = Location(-8, 0, EAST)
            )
    }

    @Nested
    @DisplayName("Given the rover initially is heading WEST")
    inner class GivenInitialHeadingIsWest {
        @Test
        fun `When position is in the center and move is called twice Then it should be at (-2, 0, WEST)`() =
            executeRoverMove(
                initialPosition = centeredHeadingWest,
                numberOfMoves = 2,
                expectedLocation = Location(-2, 0, WEST)
            )

        @Test
        fun `When position is at the far west and we move 5 times Then it should be at (6, 0, WEST)`() =
            executeRoverMove(
                initialPosition = middleFarWestHeadingWest,
                numberOfMoves = 5,
                expectedLocation = Location(6, 0, WEST)
            )
    }

    @Nested
    @DisplayName("Given the rover initially is heading NORTH")
    inner class GivenInitialHeadingIsNorth {
        @Test
        fun `When position is in the center and move is called once Then it should be at (0, 1, NORTH)`() =
            executeRoverMove(
                initialPosition = centeredHeadingNorth,
                numberOfMoves = 1,
                expectedLocation = Location(0, 1, NORTH)
            )

        @Test
        fun `When position is at the far north and we move 10 times Then it should be at (0, -1, NORTH)`() =
            executeRoverMove(
                initialPosition = middleFarNorthHeadingNorth,
                numberOfMoves = 10,
                expectedLocation = Location(0, -1, NORTH)
            )
    }

    @Nested
    @DisplayName("Given rover initially is heading SOUTH")
    inner class GivenInitialHeadingIsSouth {
        @Test
        fun `When position is in the center and move is called 11 times Then it should be back at the initial coordinates`() =
            executeRoverMove(
                initialPosition = centeredHeadingSouth,
                numberOfMoves = 11,
                expectedLocation = centeredHeadingSouth
            )

        @Test
        fun `When positioned in the far south and move is called twice Then it should be at (0, 9, SOUTH)`() =
            executeRoverMove(
                initialPosition = middleFarSouthHeadingSouth,
                numberOfMoves = 2,
                expectedLocation = Location(0, 9, SOUTH)
            )

    }


    private fun executeRoverMove(initialPosition: Location, expectedLocation: Location, numberOfMoves: Int = 1) {
        val rover = Rover(initialPosition)

        repeat(numberOfMoves) {
            rover.move()
        }

        expectThat(rover.currentLocation).isEqualTo(expectedLocation)
    }
}