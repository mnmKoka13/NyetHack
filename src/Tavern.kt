fun main(args: Array<String>) {
    // セーフコール演算子
//    var beverage = readLine()?.capitalize()
    // セーフコール演算子とlet関数
    var beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Buttered Ale"
        }
    }

//    beverage = null
    println(beverage)
}