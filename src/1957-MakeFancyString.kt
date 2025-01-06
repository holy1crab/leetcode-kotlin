// delete characters to make fancy string

fun makeFancyString(s: String): String {
    val arr = s.toCharArray().toTypedArray()
    return arr
        .filterIndexed { i, it ->
            i == 0 || i == arr.size - 1 || arr.getOrNull(i + 1) == null || !(arr[i - 1] == it && arr[i + 1] == it)
        }
        .joinToString("")
}


fun main() {
    makeFancyString("leeetcode")
    makeFancyString("aaabaaaa")
    makeFancyString("aab")
}
