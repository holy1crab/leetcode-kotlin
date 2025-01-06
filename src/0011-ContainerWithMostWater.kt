import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

fun containerWithMostWater(height: IntArray): Int {

    var res = 0

    // my honest attempt - just brute force (before I knew about 2 pointers solution)

//        for (i in height.indices) {
//            for (j in height.size - 1 downTo i + 1) {
//                val area = min(height[i], height[j]) * (j - i)
//                res = max(res, area)
//            }
//        }

    var left = 0
    var right = height.size - 1

    while (left != right) {

        val area = (right - left) * min(height[left], height[right])
        if (height[left] >= height[right]) {
            right -= 1
        } else {
            left += 1
        }

        res = max(res, area)
    }

    return res
}

fun main() {

    println(containerWithMostWater(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))) // 0..8
    println(containerWithMostWater(intArrayOf(1, 1))) // 0..1

    val hRange = 0..10.toDouble().pow(4).toInt()
    val size = 10.toDouble().pow(5).toInt()
    println(containerWithMostWater(IntArray(size) { hRange.random() })) // 0..1
}


// Hints:
// If you simulate the problem, it will be O(n^2) which is not efficient.
// Try to use two-pointers. Set one pointer to the left and one to the right of the array. Always move the pointer that points to the lower line.
// How can you calculate the amount of water at each step?
