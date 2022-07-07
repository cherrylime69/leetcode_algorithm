package array

// https://leetcode.com/problems/product-of-array-except-self/

fun main() {
    println(`Product of Array Except Self`().productExceptSelf(intArrayOf(-1,1,0,-3,3)).toList())
}

class `Product of Array Except Self` {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefix = IntArray(nums.size)
        val suffix = IntArray(nums.size)
        val result = IntArray(nums.size)

        var preNum = 1
        prefix[0] = preNum

        var sufNum = 1
        suffix[nums.size - 1] = sufNum

        for (i in 1 until nums.size) {
            preNum *= nums[i - 1]
            prefix[i] = preNum
        }

        for (i in nums.size - 2 downTo 0) {
            sufNum *= nums[i + 1]
            suffix[i] = sufNum
        }

        for (i in nums.indices) {
            result[i] = prefix[i] * suffix[i]
        }

        return result
    }
}