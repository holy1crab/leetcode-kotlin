import common.TreeNode
import common.treeNodesFromIterable

private fun <T> invertTree(root: TreeNode<T>?): TreeNode<T>? {

    if (root == null) {
        return null
    }

    val tmp = root.left
    root.left = root.right
    root.right = tmp

    invertTree(root.left)
    invertTree(root.right)

    return root
}

fun main() {

    val res = invertTree(treeNodesFromIterable(listOf(4, 2, 7, 1, 3, 6, 9)))
    println(listOf(res?.`val`, res?.left?.`val`, res?.right?.`val`)) // todo: implement `treeNodesToList`

//    val root1 = TreeNode(1)
//    root1.right = TreeNode(2)
//    val res1 = invertTree(root1)
//    println(listOf(res1?.`val`))
}

/*
Given the root of a binary tree, invert the tree, and return its root.
 */
