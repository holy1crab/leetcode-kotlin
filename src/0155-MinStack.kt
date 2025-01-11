import kotlin.collections.ArrayDeque

class MinStack {

    private val elements = ArrayDeque<Int>()

    private var min = ArrayDeque<Int>()

    fun push(value: Int) {
        elements.add(value)
        if (min.isEmpty() || value <= min.last()) {
            min.add(value)
        }
    }

    fun pop(): Int? {
        if (elements.isEmpty()) {
            return null
        }
        val last = elements.removeLast()
        if (last == min.lastOrNull()) {
            min.removeLast()
        }
        return last
    }

    fun top(): Int {
        return elements.last()
    }

    fun getMin(): Int? {
        return min.lastOrNull()
    }
}

fun main() {
//    val minStack = MinStack()
//    minStack.push(-2)
//    minStack.push(0)
//    minStack.push(-3)
//    println(minStack.getMin()) // return -3
//    minStack.pop()
//    println(minStack.top()) // return 0
//    println(minStack.getMin()) // return -2

    val minStack = MinStack()
    minStack.push(0)
    minStack.push(1)
    minStack.push(0)
    println(minStack.getMin()) // return 0
    minStack.pop()
    println(minStack.getMin()) // return 0

}

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
