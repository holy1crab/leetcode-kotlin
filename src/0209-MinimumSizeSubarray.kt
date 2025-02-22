// todo: there is room to improve
private fun minimumSizeSubArraySum(target: Int, nums: IntArray): Int {

    var len = 0
    for (index in nums.indices) {

        var sum = 0
        for (j in index downTo 0) {
            sum += nums[j]
            if (sum >= target) {
                len = if (len == 0) index - j + 1 else minOf(len, index - j + 1)
                break
            }
        }
    }

    return len
}

fun main() {
    println(minimumSizeSubArraySum(7, intArrayOf(2, 3, 1, 2, 4, 3)))
}
