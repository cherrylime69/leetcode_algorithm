package array

// https://leetcode.com/problems/two-sum/

fun main() {
    println(Solution().twoSum(intArrayOf(3, 2, 4), 6).toList())
}


class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val resultArray = IntArray(2)
        for (i in 0 until nums.size - 1) {
            for (j in (1 + i) until nums.size) {
                if (nums[i] + nums[j] == target) {
                    resultArray[0] = i
                    resultArray[1] = j
                    println("$i $j")
                    return resultArray
                }
            }
        }
        return resultArray
    }
}