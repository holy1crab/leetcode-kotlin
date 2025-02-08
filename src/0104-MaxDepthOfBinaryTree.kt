import kotlin.math.max
import common.TreeNode

/*
    my own attempt without recursion (I just didn't know recursion solution)

    on every depth level we save the array of current level nodes
    if there are no nodes then it's the max depth
 */
fun <T> maxDepth(root: TreeNode<T>?): Int {
    if (root == null) {
        return 0
    }
    var depth = 0
    val que = mutableListOf(root)

    while (que.isNotEmpty()) {

        var currSize = que.size

        while (currSize-- != 0) {
            val el = que.removeFirst()
            el.left?.apply {
                que.add(this)
            }
            el.right?.apply {
                que.add(this)
            }
        }

        depth += 1
    }

    return depth
}

/*
    what I found later
*/
fun <T> maxDepthRec(root: TreeNode<T>?): Int {
    if (root == null) {
        return 0 // start count from this (deepest from current node)
    }

    val leftDepth = maxDepthRec(root.left)
    val rightDepth = maxDepthRec(root.right)

    // basically just the number of call stack
    // f(f(f())) - every function call adds +1
    return 1 + max(leftDepth, rightDepth)
}

fun main() {

    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    root.right?.right?.right = TreeNode(8)

    println(maxDepth(root) == 4)
    println(maxDepth<Int>(null) == 0)

    println(maxDepthRec(root) == 4)
}


/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
