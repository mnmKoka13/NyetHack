import kotlin.math.roundToInt


fun main(args: Array<String>) {
    println("======================")
    println("*** Welcome to $TAVERN_NAME ***")
    println()
//    val formattedMenuList = formatMenu()
//    formattedMenuList.forEach {
//        println(it)
//    }

    displayFormattedMenu()
    println("======================")
}

private fun getMaxLength(): Int {
    var maxLen = 0
    menuList.forEach{
        val (_, name, _) = it.split(',')
        val len = name.length
        if (len > maxLen) {
            maxLen = len
        }
    }
    return maxLen
}

private fun formatMenu(): List<String> {
    val formattedList = mutableListOf<String>()
    var maxLen = getMaxLength()
    val basePadding = maxLen + 5
    menuList.forEach{
        val (type, name, price) = it.split(',')
        val padding = basePadding - name.length
        var dot = ""
        while(dot.length < padding) {
            dot += "."
        }

        formattedList.add("$name$dot$price")
    }
    return formattedList
}

private fun displayFormattedMenu() {
    var currentType = ""
    val maxLen = getMaxLength()
    menuList.sorted().forEach(){
        val (type, name, price) = it.split(',')
        if (currentType == "" || currentType != type) {
            currentType = type
            println("     〜[$currentType]〜")
        }
        val padding = maxLen - name.length + 5
        var dot = ""
        while (dot.length < padding) {
            dot += "."
        }
        println("$name$dot$price")
    }
}
