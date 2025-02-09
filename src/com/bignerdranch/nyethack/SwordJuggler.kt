package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }
    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
//    swordsJuggling ?: throw UnskilledSwordJugglerException()
    // 事前条件関数を使う
    checkNotNull(swordsJuggling, { "Playler cannot juggle swords" })
}

// カスタム例外クラス
class UnskilledSwordJugglerException():
    IllegalStateException("com.bignerdranch.nyethack.Player cannot juggle swords")