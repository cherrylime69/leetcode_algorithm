package codesquad.firstWeek

fun main() {
    val subFirst = SubFirstQuestion()
    println(subFirst.solution(3, arrayOf("tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank")).toList())
    println(subFirst.solution(5, arrayOf("hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive")).toList())
    println(subFirst.solution(2, arrayOf("hello", "one", "even", "never", "now", "world", "draw")).toList())
}

class SubFirstQuestion {

    fun solution(n: Int, words: Array<String>): IntArray {
        val answer = intArrayOf(0, 0)
        val usedWordsSet = HashSet<String>()

        words.forEachIndexed { index, word ->
            if (!usedWordsSet.add(word) || (index > 0 && words[index - 1].last() != word.first())) {
                answer[0] = (index % n) + 1
                answer[1] = (index / n) + 1
                return answer
            }
        }

        return answer
    }

}