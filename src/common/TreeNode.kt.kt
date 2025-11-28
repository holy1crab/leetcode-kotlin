package common

class TreeNode<T>(val `val`: T) {
    var left: TreeNode<T>? = null
    var right: TreeNode<T>? = null
}

fun <T> treeNodesFromIterable(list: Iterable<T?>): TreeNode<T>? {

    val iter = list.iterator()
    val rootData = if (iter.hasNext()) iter.next() else null
    if (rootData == null) {
        return null
    }

    val root = TreeNode<T>(rootData)
    val queue = mutableListOf(root)
    var leftOrRight = true
    while (iter.hasNext()) {
        val el = iter.next()
        if (el != null) {
            val nextNode = TreeNode<T>(el)
            val node = if (leftOrRight) queue[0] else queue.removeFirst()
            if (leftOrRight) node.left = nextNode else node.right = nextNode
            queue.add(nextNode)
        }
        leftOrRight = !leftOrRight
    }
    return root
}
