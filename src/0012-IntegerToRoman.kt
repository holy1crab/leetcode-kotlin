import kotlin.math.pow


fun intToRoman(num: Int): String {
    var sum = num
    var base = 0
    val res = mutableListOf<String>()
    val symbols = listOf("I", "V", "X", "L", "C", "D", "M")

    while (sum > 0) {

        val first = symbols[base * 2]
        val second = symbols.getOrNull(base * 2 + 1)
        val third = symbols.getOrNull(base * 2 + 2)
        val multi = 10f.pow(base).toInt() // 1 10 100 100 ...
        val rem = sum % (multi * 10)
        val remDigit = rem / multi

        val curr = when {
            remDigit == 4 -> first + second
            remDigit == 5 -> second
            remDigit == 9 -> first + third
            remDigit < 4 -> first.repeat(remDigit)
            else -> second + first.repeat(remDigit - 5)
        }

        res.add(0, curr.toString())

        sum -= rem
        base += 1
    }

    return res.joinToString("")
}

fun main() {

    println(intToRoman(3749) == "MMMDCCXLIX")
    println(intToRoman(58) == "LVIII")
    println(intToRoman(1994) == "MCMXCIV")

//    assert(intToRoman(3749) == "MMMDCCXLIX")
//    assert(intToRoman(58) == "LVIII")
//    assert(intToRoman(1994) == "MCMXCIV")
}


/*
Example 1:

Input: num = 3749

Output: "MMMDCCXLIX"

Explanation:

3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
700 = DCC as 500 (D) + 100 (C) + 100 (C)
40 = XL as 10 (X) less of 50 (L)
9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
Example 2:

Input: num = 58

Output: "LVIII"

Explanation:

50 = L
8 = VIII
Example 3:

Input: num = 1994

Output: "MCMXCIV"

Explanation:

1000 = M
900 = CM
90 = XC
4 = IV


Constraints:

1 <= num <= 3999
*/
