package software.steinhauer.interviews.ee

class Rover(initialLocation: Location) {

    private val lowerBound = -10
    private val upperBound = 10

    var currentLocation = initialLocation

    fun move() {
        when (currentLocation.direction) {
            Directions.EAST -> currentLocation.x = getNextValue(currentLocation.x)
        }
    }

    private fun getNextValue(currentPosition: Int) =
        if (currentPosition < upperBound)
            currentPosition + 1
        else
            lowerBound
}