import kotlin.math.pow

// latest 10% :( read from solutions that the slow/first pointer should be used (should try the next time)
private fun happyNumber(n: Int): Boolean {

    var num = n
    val allResults = mutableSetOf<Int>()

    while (!allResults.contains(num)) {

        allResults.add(num)

        val ns = num.toString()
        num = ns.asSequence().fold(0) { acc, s ->
            acc + (s.digitToInt().toFloat().pow(2).toInt())
        }
        if (num == 1) {
            return true
        }
    }
    return false
}


fun main() {
    println(happyNumber(19))
    println(happyNumber(192))
    println(happyNumber(1928))
}
