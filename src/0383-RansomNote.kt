private fun canConstruct(ransomNote: String, magazine: String): Boolean {
    if (magazine.length < ransomNote.length) {
        return false
    }

    val dict = mutableMapOf<Char, Int>()
    for (ch in magazine) {
        dict[ch] = (dict[ch] ?: 0) + 1
    }

    for (ch in ransomNote) {
        val n = dict[ch] ?: 0
        if (n == 0) {
            return false
        }
        dict[ch] = n - 1
    }

    return true
}

fun main() {
    println(canConstruct("abc", "aabcd"))
    println(canConstruct("a", "b"))
    println(canConstruct("aa", "ab"))
    println(canConstruct("aa", "aab"))
}
