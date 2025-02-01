fun main() {
    // Player
    val player = Player()
    player.castFireball()

    // Aura
    val auraColor = player.auraColor()

    // Player Status
    printPlayerStatus(player)

}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}

