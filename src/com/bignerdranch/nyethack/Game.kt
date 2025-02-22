package com.bignerdranch.nyethack

import Room
import TownSquare

fun main() {
    Game.play()
}


// objectキーワード：シングルトンオブジェクト
//　最初にアクセスされた時、そのクラスのインスタンスがただ１つ生成される
// プログラム実行中は常に同じインスタンスを返す
object Game {
    val player = Player("Madrigal")
    var currentRoom: Room = TownSquare()

    init {
        println("Welcome, adventure.")
        player.castFireball()
    }

    fun play() {
        while (true) {
            // Play NyetHack
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor()}) " +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, {""})

        fun processCommand() = when (command.toLowerCase()) {
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }
}
