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
            println("Last command: ${readLine()}")
        }
    }

    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor()}) " +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }
}
