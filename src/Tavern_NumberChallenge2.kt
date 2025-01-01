import kotlin.math.roundToInt

var playerGold2 = 0
var playerSilver2 = 0
var playerDragonCoin = 5.0

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
//    placeOrder(("elixir,Shirley's Temple,4.12"))
}

fun performPurchase3(price: Double) {
    displayBalance()
    val totalPurse = (playerDragonCoin * 1.43) + playerGold2 + (playerSilver2 / 100.0)
    println("Total purse: ${"%.2f".format(totalPurse)}")

    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingDragonCoin = (remainingBalance / 1.43)
    playerDragonCoin = remainingDragonCoin
    displayBalance()
    displayRemainingDragonsBreath()
}

private fun displayBalance() {
    println("Player's purse balance: DragonCoin: ${"%.4f".format(playerDragonCoin)} Gold: $playerGold2 , Silver: $playerSilver2")
}

private fun displayRemainingDragonsBreath() {
    val remainingDragonBreath = 5
    val remainingDragonBreathPint = remainingDragonBreath / 0.125
    println("12pint of Dragon's Breath are consumed.")
    println("Remaining Dragon's Breath: ${remainingDragonBreathPint - 12}pint")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    // 1行で書く
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name($type) of $price."
    println(message)

    performPurchase3(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        println("Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}")
    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when(it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }