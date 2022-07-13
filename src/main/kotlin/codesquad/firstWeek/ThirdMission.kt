package codesquad.firstWeek

import java.util.Stack

fun main() {
    val third = ThirdMission()
    println(third.solution("()()"))
    println(third.solution("(())()"))
    println(third.solution(")()("))
    println(third.solution("(()("))

}


class ThirdMission {
    fun solution(string: String): Boolean {
        val stack = Stack<Char>()

        string.forEach {
            if (it == '(') {
                stack.push(it)
            } else {
                if (stack.isNotEmpty()) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}