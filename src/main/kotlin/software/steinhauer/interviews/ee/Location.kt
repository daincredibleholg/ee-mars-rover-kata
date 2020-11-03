package software.steinhauer.interviews.ee

data class Location (
    var x: Int,
    var y: Int,
    var direction: Directions
)

enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
