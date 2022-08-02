package codesquad.fourthWeek


fun main() {
    val firstQuestion = FirstQuestion()
    println(firstQuestion.solution("1924", 2))
    println(firstQuestion.solution("1231234", 3))
    println(firstQuestion.solution("4177252841", 4))
    println(firstQuestion.solution("12004", 4))
    println(firstQuestion.solution("21", 1))
    println(firstQuestion.solution("333", 1))
    println(firstQuestion.solution("7001889", 3))
    println(firstQuestion.solution("987654", 3))
}

/*
class FirstQuestion {
    fun solution(number: String, k: Int): String {
        val maxIndex = number.indexOf(number.substring(0, k + 1).maxOrNull()!!)
//        println(maxIndex)
        var answer = number.removeRange(0, maxIndex)
//        println(slicedNumber)
//        var maxIndex = number.indexOf(number.maxOrNull()!!)
//        println(maxIndex)
        var count = k - maxIndex
//        println(count)


        while (count > 0) {
            val index = if (count + 3 <= answer.lastIndex) count + 3 else answer.length
            val slicedAnswer = answer.substring(1, index)
//            println(slicedAnswer)
//            println(slicedAnswer.minOrNull()!!)
            val minIndex = answer.indexOf(slicedAnswer.minOrNull()!!)
            answer = answer.removeRange(minIndex, minIndex + 1)
//            println(slicedNumber)
//            val minIndex = answer.indexOf(answer.minOrNull()!!)
//            answer = answer.removeRange(minIndex, minIndex + 1)
            count--
        }


//        for (i in 1 until answer.length - 1) {
//            if (answer[i] < answer[i + 1]) {
//                answer = answer.removeRange(i, i + 1)
//                count--
//            }
//            if (count == 0) break
//            if (i == answer.lastIndex) answer = answer.removeRange(0, answer.lastIndex - count)
//        }

        return answer
    }
}*/

class FirstQuestion {
    fun solution(number: String, k: Int): String {
        var answer = StringBuilder()
        var start = 0

        for (i in 0 until number.length - k) {
            var max = '0'
            for (j in start .. i + k) {
                if (number[j] > max) {
                    max = number[j]
                    start = j + 1
                }
            }
            answer.append(max)
        }

        return answer.toString()
    }
}