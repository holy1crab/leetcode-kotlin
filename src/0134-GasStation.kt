/* topics: Array Greedy */

/* first working attempt - doesn't pass in time (brut-force basically) */

//fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
//    val size = gas.size
//
//    for (startIndex in 0..<size) {
//
//        var currentGas = 0
//        for (i in 0..<size) {
//            var ii = i + startIndex
//            if (ii >= size) {
//                ii -= size
//            }
//
//            currentGas += (gas[ii] - cost[ii])
//
//            if (currentGas < 0) {
//                break
//            }
//        }
//        if (currentGas >= 0) {
//            return startIndex
//        }
//    }
//}

// can't deal with it, looking for Discussion, found this
// > Hint: if you start from station a and stuck at b, then you can't get to b from any station between a and b.
// and I didn't get how it works :)

/*
edited:
a few moments later...
figured it out, so why this hint useful, and it works
let's imagine that we are driving from a -> b -> c -> d -> e (on `d` we got minus, so it means we didn't get the "d" station)
but this also means that on previous stations we got positive (or zero) difference in sum,
so `a` (positive) + `b` (positive) + `c` (positive) > 0 and finally on `d` we got `negative` ->
`a` + `b` + `c` < `d`
-> `b` + `c` < `d`
-> `c` < `d`
it means that there is no point to check `b` starting index or `c` starting index,
they all will be less than `d` at this point
 */
fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val size = gas.size
    var startIndex = 0
    while (startIndex < size) {

        var currentGas = 0
        for (i in 0..<size) {

            var ii = i + startIndex
            if (ii >= size) {
                ii -= size
            }

            currentGas += (gas[ii] - cost[ii])

//            println("index:$i -${cost[ii]}=${currentGas}")

            if (currentGas < 0) {
                startIndex += i + 1
                break
            }
        }
        if (currentGas >= 0) {
            return startIndex
        }
    }

    return -1
}

fun main() {
    println(canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
    println(canCompleteCircuit(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)))
}


/*
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.



Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.


Constraints:

n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 104
 */
