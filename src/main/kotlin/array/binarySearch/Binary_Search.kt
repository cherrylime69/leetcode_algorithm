package array.binarySearch

//https://leetcode.com/problems/binary-search/
//https://www.youtube.com/watch?v=Ix-7qWQr_RE&list=PLDV-cCQnUlIYFOXYzqLoXnEye4WxDa_30&index=3

fun main() {
    println(Binary_Search().search(intArrayOf(-1,0,3,5,9,12), 9))
    println(Binary_Search().search(intArrayOf(-1,0,3,5,9,12), 2))
}

class Binary_Search {

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val pivot = (left + right) / 2
            if (nums[pivot] == target) return pivot
            else if (nums[pivot] < target) {
                left = pivot + 1
            } else {
                right = pivot - 1
            }
        }

        return -1
    }
}