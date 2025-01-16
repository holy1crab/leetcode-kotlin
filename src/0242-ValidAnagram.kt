/*
// gives almost the last place in terms of efficiency :)
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    return s.toCharArray().sorted().joinToString("") == t.toCharArray().sorted().joinToString("")
}
*/

/*
// second attempt (there was a hint with hashmap tag)

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    val m = mutableMapOf<Char, Int>()
    for (c in s.toCharArray()) {
        m[c] = m.getOrDefault(c, 0) + 1
    }

    for (c in t.toCharArray()) {
        val count = m[c] ?: return false
        m[c] = count - 1
        if (m[c] == 0) {
            m.remove(c)
        }
    }

    return m.isEmpty()
}
*/

// came up with a beautiful solution!
fun isAnagram(s: String, t: String): Boolean {

    if (s.length != t.length) {
        return false
    }

    val map = mutableMapOf<Char, Int>()

    for (i in s.indices) {
        map[s[i]] = map.getOrDefault(s[i], 0) + 1
        map[t[i]] = map.getOrDefault(t[i], 0) - 1
    }

    return map.values.all { value -> value == 0 }
}

fun main() {

    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("aǰnǗ", "ǰǗan"))
    println(isAnagram("abc", "abf"))
}


/*
Given two strings s and t, return true if t is an
anagram
 of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
