package codesquad.thirdWeek

//https://school.programmers.co.kr/tryouts/45257/challenges?language=kotlin

fun main() {
    val subFirst = SubFirstQuestion()
    println(subFirst.solution(intArrayOf(1, 2, 3, 4)))
    println(subFirst.solution(intArrayOf(1, 2, 7, 6, 4)))
}

class SubFirstQuestion {

    fun solution(nums: IntArray): Int {
        var answer = 0

        for (first in nums.indices) {
            for (second in 1 + first until nums.size) {
                for (third in 1 + second until nums.size) {
                    val sum = nums[first] + nums[second] + nums[third]
                    if (isPrime(sum)) answer++
                }
            }
        }
        return answer
    }

    fun isPrime(num: Int): Boolean {
        var i = 2
        while (i * i <= num) {
            if (num % i++ == 0) return false
        }
        return true
    }

}