package common

class TreeNode<T>(val `val`: T) {
    var left: TreeNode<T>? = null
    var right: TreeNode<T>? = null
}

fun <T> treeNodesFromIterable(list: Iterable<T>): TreeNode<T>? {

    val iter = list.iterator()
    if (!iter.hasNext()) {
        return null
    }

    val root = TreeNode(iter.next())
    val queue = mutableListOf(root)
    var leftOrRight = true
    while (iter.hasNext()) {
        val el = iter.next()
        val nextNode = TreeNode(el)
        val node = if (leftOrRight) queue[0] else queue.removeFirst()
        if (leftOrRight) node.left = nextNode else node.right = nextNode
        leftOrRight = !leftOrRight
        queue.add(nextNode)
    }
    return root
}
