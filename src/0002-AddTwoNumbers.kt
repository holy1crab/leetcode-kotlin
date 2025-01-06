class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val res = ListNode(3)
    return res
}

fun main() {
    val first1 = ListNode(2)
    val second1 = ListNode(4)
    first1.next = second1
    val third = ListNode(3)
    second1.next = third

    val first2 = ListNode(5)
    val second2 = ListNode(6)
    first2.next = second2
    val third2 = ListNode(4)
    second2.next = third2
    println(addTwoNumbers(first1, first2))
}
