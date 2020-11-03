package software.steinhauer.interviews.ee

class Rover(initialLocation: Location) {

    private val lowerBound = -10
    private val upperBound = 10

    var currentLocation = initialLocation

    fun move() {
        when (currentLocation.direction) {
            Directions.NORTH -> currentLocation.y = increment(currentLocation.y)
            Directions.EAST -> currentLocation.x = increment(currentLocation.x)
            Directions.WEST -> currentLocation.x = decrement(currentLocation.x)
        }
    }

    private fun decrement(currentPosition: Int) =
        if (currentPosition > lowerBound)
            currentPosition - 1
        else
            upperBound

    private fun increment(currentPosition: Int) =
        if (currentPosition < upperBound)
            currentPosition + 1
        else
            lowerBound
}