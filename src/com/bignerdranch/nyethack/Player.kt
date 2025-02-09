package com.bignerdranch.nyethack

class Player(_name: String,
            var healthPoints: Int = 100,
            var isBlessed: Boolean,
            private val isImmortal: Boolean) {
    // プロパティ
    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    // 初期化ブロック
    init {
        require(healthPoints > 0, {"healthPoints must be greater than zero."})
        require(name.isNotBlank(), {"Player must have a name"})
    }

    constructor(name: String): this(name,
            isBlessed = true,
            isImmortal = false) {
        if (name.toLowerCase() == "kar") healthPoints = 40
    }

    // クラスメソッド
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs int existence.(x$numFireballs)")

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus() =
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
}