import common.TreeNode
import common.treeNodesFromIterable

/*
private fun getMinimumDifference(root: TreeNode<Int>?): Int {
    if (root == null) {
        return 0
    }

    val iter = mutableListOf(root)
    var min1 = root.`val`
    var min2 = root.`val`

    while (iter.size > 0) {
        val el = iter.removeFirst()
        val value = el.`val`

        if (value < min1) {
            min2 = min1
            min1 = value
        } else if (value < min2 && value > min1) {
            min2 = value
        }

        val left = el.left
        val right = el.right
        if (left != null) {
            iter.add(left)
        }
        if (right != null) {
            iter.add(right)
        }
    }

    return min2 - min1
}
*/


private fun recursive(node: TreeNode<Int>?, elements: MutableList<Int>) {
    if (node == null) {
        return
    }
    recursive(node.left, elements)
    println(node.`val`)
    elements.add(node.`val`)
    recursive(node.right, elements)
}

private fun getMinimumDifference(root: TreeNode<Int>?): Int {
    val sortedElements = mutableListOf<Int>()
    recursive(root, sortedElements)
    return 0
}

fun main() {

    println(getMinimumDifference(treeNodesFromIterable(listOf(4, 2, 6, 1, 3))))
//    println(getMinimumDifference(treeNodesFromIterable(listOf(1, null, 3, 2))))
}
