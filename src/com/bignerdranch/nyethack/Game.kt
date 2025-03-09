package com.bignerdranch.nyethack

import Direction
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
    var continueFlg = true

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    init {
        println("Welcome, adventure.")
        player.castFireball()
    }

    fun play() {
        while (continueFlg) {
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
            "move" -> move(argument)
            "quit" -> quitGame()
            "exit" -> quitGame()
            "map" -> viewMap()
            "ring" -> if (currentRoom is TownSquare) (currentRoom as TownSquare).ringBell() else "You're not in TownSquare."
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }


    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)

            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput"
        }

    private fun quitGame() {
        println("farewell message to the adventurer.")
        continueFlg = false
    }

    private fun viewMap() {
        for (y in 0 until worldMap.size) {
            for (x in 0 until worldMap[y].size) {
                if (worldMap[y][x] == currentRoom) {
                    print("X ")
                } else {
                    print("O ")
                }
            }
            println("")
        }
    }
}
