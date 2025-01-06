fun lengthOfLongestSubstring(s: String): Int {
    val arr = s.toCharArray().toTypedArray()
    var maxSub = 0
    var currentSub = emptyArray<Char>()
    for (letter in arr) {
        val index = currentSub.indexOf(letter)
        currentSub += letter
        if (index > -1) {
            currentSub = currentSub.sliceArray(index + 1..<currentSub.size)
        }
        maxSub = maxSub.coerceAtLeast(currentSub.size)
    }

    return maxSub
}

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
}
