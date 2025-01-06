fun isCircularSentence(sentence: String): Boolean {
    val arr = sentence.split(" ")
    return arr.withIndex().all { (i, v) -> v[v.length - 1] == arr[if (i == arr.size - 1) 0 else i + 1][0] }
}

fun main() {
    assert(isCircularSentence("leetcode exercises sound delightful"), fun() { println("test") })
}
