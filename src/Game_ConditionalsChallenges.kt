fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = when (karma) {
            in 0..5 -> "red"
            in 6..10 -> "orange"
            in 11..15 -> "purple"
            else -> "green"
    }

    // Health Status
    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    // Player Status
    val statusFormatString = ("(HP: $healthPoints)(Aura: ${if (auraVisible) auraColor else "NONE"})"
            + "-> $name $healthStatus")


//    println(karma)
    println(statusFormatString)

}