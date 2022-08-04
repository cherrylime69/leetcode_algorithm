package backTracking

import java.util.*

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// https://www.youtube.com/watch?v=Ar40zcPoKEI&list=PLDV-cCQnUlIaAKZbfdkMU01MrMkeTvVgP&index=2

fun main() {
    val letter = Letter_Combinations_of_a_Phone_Number()
    println(letter.letterCombinations("23"))
}

class Letter_Combinations_of_a_Phone_Number {

    fun letterCombinations(digits: String): List<String> {
        val answer = mutableListOf<String>()
        val letterMap = mapOf<Char, String>(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )
        val startIndex = 0

        if (digits.isNotEmpty()) {
            for (i in letterMap[digits[startIndex]]!!) {
                bt(answer, digits, letterMap, startIndex + 1, i.toString())
            }
        }

        return answer
    }

    fun bt(answer: MutableList<String>, digits: String, letterMap: Map<Char, String>, index: Int, letter: String) {
        if (index >= digits.length) {
            answer.add(letter)
            return
        }
        val num = digits[index]
        val char = letterMap[num]!!

        for (i in char) {
            bt(answer, digits, letterMap, index + 1, letter + i)
        }
    }

    /*fun letterCombinations(digits: String): List<String> {
        val answer = mutableListOf<String>()
        val letterMap = mapOf<Char, String>(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )
        val stack = Stack<String>()
        var startIndex = 0

        for (i in letterMap[digits[startIndex]]!!) {
            stack.push(i.toString())
        }

        while (stack.isNotEmpty()) {
            startIndex++
            val currentLetter = stack.pop()
            if (startIndex >= digits.length) {
                answer.add(currentLetter)
            }
            else {
                println(startIndex)
                val nextLetters = letterMap[digits[startIndex]]!!
                for (nextLetter in nextLetters) {
                    stack.push(currentLetter + nextLetter)
                }
            }
            println(stack)
        }

        return answer
    }*/

}