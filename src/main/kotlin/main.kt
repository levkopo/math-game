import java.util.*
import kotlin.random.Random
import kotlin.system.exitProcess

const val SECOND_IN_MILLIS = 1000L
const val MAX_NUMBER = 999

val operations = mapOf<String, (Number, Number) -> Number>(
    "+" to { a, b -> a.toInt()+b.toInt() },
    "-" to { a, b -> a.toInt()-b.toInt() },
)

val answers = mutableListOf<Long>()
var expressions = 0

fun main() {
    println("Математический тренировщик")

    Scanner(System.`in`).use {
        while(true) {
            val a = Random.nextInt(MAX_NUMBER)
            val b = Random.nextInt(MAX_NUMBER)
            val operation = operations.entries.shuffled().first()
            val answer = operation.value(a, b)

            val startTime = System.currentTimeMillis()
            print("$a${operation.key}$b=")
            when(it.nextLine()) {
                ":quit", ":q" -> quit()

                answer.toString() -> {
                    val answerTime = System.currentTimeMillis() - startTime
                    answers.add(answerTime)

                    println("Правильный ответ. Вы ответили на пример за ${answerTime/SECOND_IN_MILLIS} секунды")
                }

                else -> {
                    println("Неверный ответ! $answer")
                }
            }

            expressions++
        }
    }
}

fun quit() {
    println("${answers.size} правельных ответов из $expressions")
    if(answers.size==0)
        println("Среднее время вычисления: ${answers.average()/SECOND_IN_MILLIS}с")
    else println("Плохой из тебя математик")
    exitProcess(0)
}
