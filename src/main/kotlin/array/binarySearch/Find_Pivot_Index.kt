package array.binarySearch

fun main() {
    val find = Find_Pivot_Index()
    println(find.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
    println(find.pivotIndex(intArrayOf(1, 2, 3)))
    println(find.pivotIndex(intArrayOf(2, 1, -1)))

}

class Find_Pivot_Index {
//    브루트 포스 풀이
//   fun pivotIndex(nums: IntArray): Int {
//        val sum = nums.sum()
//        var leftSum = 0
//        var rightSum = sum
//        var previousPivot = 0
//
//        for (pivot in nums.indices) {
//            val num = nums[pivot]
//            leftSum += previousPivot
//            rightSum -= num
//            if (leftSum == rightSum) return pivot
//            previousPivot = num
//        }
//        return -1
//    }
//    문제 해설보고 슬라이딩 활용하여 내 스스로 문제 풀이
//    fun pivotIndex(nums: IntArray): Int {
//        val sum = nums.sum()
//        var leftSum = 0
//        var rightSum = sum
//
//        for (pivot in nums.indices) {
//            if (pivot > 0) leftSum += nums[pivot - 1]
//            rightSum -= nums[pivot]
//            if (leftSum == rightSum) return pivot
//        }
//        return -1
//    }
    // 문제 해설에서 나온 샘플 코드
    fun pivotIndex(nums: IntArray): Int {
        val sum = nums.sum()
        var leftSum = 0
        var rightSum = sum

        for (pivot in nums.indices) {
            if (pivot > 0) leftSum += nums[pivot - 1]
            rightSum -= nums[pivot]
            if (leftSum == rightSum) return pivot
        }
        return -1
    }

}