package codesquad.thirdWeek

fun main() {
    val first = FirstQuestion()
    println(first.solution("aabbaccc")) //2a2ba3c
    println(first.solution("ababcdcdababcdcd"))
    println(first.solution("abcabcdede"))
    println(first.solution("abcabcabcabcdededededede"))
    println(first.solution("xababcdcdababcdcd"))
}

class FirstQuestion {
    fun solution(s: String): Int {
        val answerList = MutableList<Int>(s.length) { s.length }
        var answer = ""
        var original = s

        for (i in 1 until s.length - 1) {
            var index = i
            var standard = s.substring(0 until index)
            var count = 0
            while (original.isNotEmpty()) {
                if (index >= original.length) index = original.length
                val currentString = original.substring(0 until index)
                original = original.removeRange(0 until index)
                if (standard == currentString) {
                    count++
                } else {
                    if (count == 0 || count == 1) answer = answer + standard
                    else answer = answer + count.toString() + standard
                    count = 1
                    standard = currentString
                }
            }
            if (count > 0 ) {
                if (count == 1) answer = answer + standard
                else answer = answer + count.toString() + standard
            }
            answerList[i] = answer.length
            answer = ""
            original = s
        }
        return answerList.minOf { it }
    }
}