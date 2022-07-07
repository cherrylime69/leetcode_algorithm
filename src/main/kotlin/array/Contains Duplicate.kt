package array

fun main() {
    println(`Contains Duplicate`().containsDuplicate(intArrayOf(3,3)))
}

/*class `Contains Duplicate` {
    fun containsDuplicate(nums: IntArray): Boolean {
        val numSet = HashSet<Int>()

        nums.forEach {
            if (!numSet.add(it)) return true
        }

        return false
    }
}*/

class `Contains Duplicate` {
    fun containsDuplicate(nums: IntArray): Boolean {
        var preNum = nums[0]

        nums.sort()

        for (i in 1 until nums.size) {
            if (preNum == nums[i]) return true
            preNum = nums[i]
        }
        return false
    }
}
