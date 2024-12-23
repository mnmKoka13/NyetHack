fun main(args: Array<String>) {
    // 二重感嘆符演算子
    var beverage = readLine()

//    beverage = null

    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing -beverage was null!")
    }
 
    // null合体演算子
    val beverageServed: String = beverage ?: "Butter Ale"
    println(beverageServed)
}