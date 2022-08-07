package array

fun main() {
    val move = Move_Zeroes()
    println(move.moveZeroes(intArrayOf(0,1,0,3,12)))
    println(move.moveZeroes(intArrayOf(0)))
    println(move.moveZeroes(intArrayOf(1)))
    println(move.moveZeroes(intArrayOf(1, 0)))
    println(move.moveZeroes(intArrayOf(1, 0, 0)))
    println(move.moveZeroes(intArrayOf(1, 0, 1)))
}

class Move_Zeroes {
    // 버블 정렬 풀이
    /*fun moveZeroes(nums: IntArray): Unit {
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == 0) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                }
            }
        }
    }*/

    // 내가 한 투포인터 풀이
    /*fun moveZeroes(nums: IntArray): Unit {
        var zeroPointer = 0
        var nonZeroPointer = 0

        while (nonZeroPointer < nums.size) {
            if (nums[zeroPointer] == 0 && nums[nonZeroPointer] != 0) {
                val temp = nums[zeroPointer]
                nums[zeroPointer] = nums[nonZeroPointer]
                nums[nonZeroPointer] = temp
                if (zeroPointer < nums.lastIndex) zeroPointer++
                if (nonZeroPointer < nums.lastIndex) nonZeroPointer++
            }
            if (nums[zeroPointer] != 0) zeroPointer++
            if (nums[nonZeroPointer] == 0) nonZeroPointer++
            if (nonZeroPointer <= zeroPointer) nonZeroPointer++
        }
        println(nums.contentToString())
    }*/

    // 문제 풀이보고 다시 작성한 풀이 (for문으로 더 간결해짐)
    /*fun moveZeroes(nums: IntArray): Unit {
        var zeroIndex = 0

        for (nonZero in nums.indices) {
            if (nums[nonZero] != 0) {
                swap(nums, zeroIndex, nonZero)
                zeroIndex++
            }
        }
        println(nums.contentToString())
    }

    fun swap (array: IntArray, first: Int, second: Int) {
        val temp = array[first]
        array[first] = array[second]
        array[second] = temp
    }*/

    // swap 이 아니라 copy + 0으로 덮어쓴 풀이
    fun moveZeroes(nums: IntArray): Unit {
        var zeroIndex = 0

        for (nonZero in nums.indices) {
            if (nums[nonZero] != 0) {
                nums[zeroIndex] = nums[nonZero]
                zeroIndex++
            }
        }

        for (zero in zeroIndex until nums.size) {
            nums[zero] = 0
        }

        println(nums.contentToString())
    }

}