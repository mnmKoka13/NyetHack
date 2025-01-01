import kotlin.math.roundToInt


fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("shandy,Dragon's Breath,5.91")
//    placeOrder(("elixir,Shirley's Temple,4.12"))
}

fun performPurchase2(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")

    if (totalPurse < price) {
        throw IllegalStateException("The Customer is short on gold.")
    }
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
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

    try {
        performPurchase2(price.toDouble())
        val phrase = if (name == "Dragon's Breath") {
            println("Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}")
        } else {
            "Madrigal says: Thanks for the $name."
        }
        println(phrase)
    } catch (e: Exception) {
        println(e)
    }
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