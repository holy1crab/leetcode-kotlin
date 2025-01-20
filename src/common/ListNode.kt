package common

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

internal fun listToLL(list: List<Int>): ListNode? {
    if (list.isEmpty()) {
        return null
    }
    val init = ListNode(list[0])
    var head = init
    for (i in 1..<list.size) {
        head.next = ListNode(list[i])
        head = head.next as ListNode
    }
    return init
}

internal fun llToList(head: ListNode?): List<Int> {
    if (head == null) {
        return emptyList()
    }
    val l = mutableListOf<Int>()
    var iter = head
    while (iter != null) {
        l.add(iter.`val`)
        iter = iter.next
    }
    return l
}
