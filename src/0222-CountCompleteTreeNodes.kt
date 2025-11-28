import common.TreeNode
import common.treeNodesFromIterable
import kotlin.math.pow

private fun <T> countNodes(root: TreeNode<T>?): Int {



    val mostLongestPathCount = 3

    // geometric progression sum formula b1 * (q^n - 1) / q - 1;
    // q=2, b1=1, so in our case it will be q^n - 1

    val withoutLastRowCount = (2f.pow(mostLongestPathCount - 1) - 1).toInt()

    return withoutLastRowCount
}

fun main() {
    println(countNodes(treeNodesFromIterable(listOf(1, 2, 3, 4, 5, 6))))
}

/*
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.
 */
