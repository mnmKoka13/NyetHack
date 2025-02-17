package com.bignerdranch.nyethack

import Room
import TownSquare

fun main() {
    // com.bignerdranch.nyethack.Player
    val player = Player("Madrigal")
    player.castFireball()

    // Aura
    val auraColor = player.auraColor()

    var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    // com.bignerdranch.nyethack.Player Status
    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}

