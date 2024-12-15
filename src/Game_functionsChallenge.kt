fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    var currentInebriation = 0

    // Aura
    val auraColor = getAuraColor(isBlessed, healthPoints, isImmortal)

    // Health Status
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Player Status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    // Cast Fireball
    currentInebriation = castFireBall(31, currentInebriation)
    printInebriationStatus(currentInebriation)
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

// 単一式関数に変更
private fun getAuraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

// 単一式関数に変更
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
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

// 単一式関数に変更
private fun castFireBall(numFireballs: Int = 2, currentInebriation: Int) : Int {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    return currentInebriation + numFireballs
}

private fun printInebriationStatus(currentInebriation: Int) {
    val status = when (currentInebriation) {
        in 1..10 -> "ほろ酔い"
        in 11..20 -> "へべれけ"
        in 21..30 -> "へろへろ"
        in 31..40 -> "ぐでんぐでん"
        else -> "..tOaSt3d"
    }
    println(status)
}
