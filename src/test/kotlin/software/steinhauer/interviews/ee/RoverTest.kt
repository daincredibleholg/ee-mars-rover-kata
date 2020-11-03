package software.steinhauer.interviews.ee

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import software.steinhauer.interviews.ee.Directions.*
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class RoverTest {

    private val centeredHeadingEast: Location = Location(0, 0, EAST)
    private val centeredHeadingWest: Location = Location(0, 0, WEST)
    private val middleFarEastHeadingEast: Location = Location(10, 0, EAST)

    @Nested
    @DisplayName("Given (0, 0, EAST) as initial location")
    inner class GivenInitialisedCenteredHeadingEast {

        @Test
        fun `When invoking move Then rover is located at (1, 0, EAST)`() {
            val rover = Rover(centeredHeadingEast)
            rover.move()
            expectThat(rover.currentLocation).isEqualTo(Location(1, 0, EAST))
        }

        @Test
        fun `When invoking move twice Then rover is located at (2, 0, EAST)`() {
            val rover = Rover(centeredHeadingEast)
            rover.move()
            rover.move()

            expectThat(rover.currentLocation).isEqualTo(Location(2, 0, EAST))
        }
    }

    @Nested
    @DisplayName("Given (10, 0, EAST) as initial location")
    inner class GivenInitialisedMiddleFarEastHeadingEast {

        @Test
        fun `When invoking move Then rover is on the far west side`() {
            val rover = Rover(middleFarEastHeadingEast)
            rover.move()

            expectThat(rover.currentLocation).isEqualTo(Location(-10, 0, EAST))
        }

        @Test
        fun `When invoking move three times Then rover is located at (-8, 0, EAST)`() {
            val rover = Rover(middleFarEastHeadingEast)
            repeat(3) {
                rover.move()
            }

            expectThat(rover.currentLocation).isEqualTo(Location(-8, 0, EAST))

        }
    }

    @Nested
    @DisplayName("Given (0, 0, WEST) as initial location")
    inner class GivenInitialisedCenteredHeadingWest {

        @Test
        fun `When invoking move four times Then rover is on (-1, 0, WEST)`() {
            val rover = Rover(centeredHeadingWest)
            rover.move()

            expectThat(rover.currentLocation).isEqualTo(Location(-1, 0, WEST))
        }

        @Test
        fun `When invoking move 4 times THen rover is on (-4, 0, WEST)`() {
            val rover = Rover(centeredHeadingWest)
            repeat(4) {
                rover.move()
            }

            expectThat(rover.currentLocation).isEqualTo(Location(-4, 0, WEST))
        }
    }

}