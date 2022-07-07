package dp

// https://leetcode.com/problems/climbing-stairs/

fun main() {
    println(`Climbing Stairs`().climbStairs(6))
}

class `Climbing Stairs` {
    fun climbStairs(n: Int): Int {
        val result = IntArray(46)

        result[1] = 1
        result[2] = 2

        for (i in 3 .. 45) {
            result[i] = result[i - 1] + result[i - 2]
        }

        return result[n]
    }

}


// 재귀 함수로 풀이 가능
/*
class Solution {
    val cache = IntArray(46)

    fun climbStairs(n: Int): Int {

        return when(n) {
            1 -> 1
            2 -> 2
            3 -> 3
            else -> {
                if (cache[n] != 0) return cache[n]
                cache[n] = climbStairs(n-1) + climbStairs(n-2)
                return cache[n]
            }
        }
    }
}*/
