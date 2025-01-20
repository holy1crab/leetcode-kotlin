import common.ListNode
import common.listToLL
import common.llToList

/*
// the first working solution - latest 5% !!
// the idea is to iterate linked list and store the K-size array of latest items
fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 0) {
        return head
    }
    val que = ArrayDeque<ListNode>()
    var iter = head
    while (iter != null) {

        que.add(iter)

        if (que.size > k + 1) {
            que.removeFirst()
        }

        iter = iter.next
    }

    var newHead = head
    var nRotate = if (que.size > k) que.size - 1 else k % que.size

    if (nRotate > 0) {

        while (nRotate > 0) {
            val el = que.removeLast()
            el.next = newHead
            newHead = el
            nRotate--
        }

        // this will be tail
        que.last().next = null
    }

    return newHead
}
*/

/*
    In the discussions I found the hint to make the list cyclic and then move forward for the required steps
    and break the list
    beats 100% runtime!! (I guess there is a mistake)
 */
fun rotateRight(head: ListNode?, k: Int): ListNode? {

    if (head == null || k == 0) {
        return head
    }

    var iter = head
    var last: ListNode? = null
    var n = 0
    while (iter != null) {
        n += 1
        last = iter
        iter = iter.next
    }

    // cycling
    last?.apply {
        next = head
    }

    var r = n - k % n

    while (r > 0) {
        last = last?.next
        r--
    }
    val newHead = last?.next
    last?.apply {
        next = null
    }

    return newHead
}

private fun main() {

    println(llToList(rotateRight(listToLL(listOf(1, 2, 3, 4, 5)), 2))) // [4, 5, 1, 2, 3]
    println(llToList(rotateRight(listToLL(listOf(2, 3, 1)), 5))) // [3, 1, 2]
    println(llToList(rotateRight(listToLL(listOf(1, 2, 3)), 6))) // [1, 2, 3]
    println(llToList(rotateRight(listToLL(listOf(0, 1, 2)), 4))) // [0, 1, 2] -> [2, 0, 1]
}

/*
Given the head of a linked list, rotate the list to the right by k places.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]


Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */
