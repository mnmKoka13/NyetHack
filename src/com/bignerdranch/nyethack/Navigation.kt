import java.awt.ComponentOrientation

enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    fun updateCoordinate(playerCoordinate: Coordinate) =
        coordinate + playerCoordinate
}

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0

    // 演算子の多重定義
    // その他よく使われる多重定義可能な演算子
    // +=: plusAssign, ==: equals, >: compareTo, []: get, ..: rangeTo, in: contains
    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}