import java.util.*
import kotlin.random.Random

val operations = mapOf<String, (Number, Number) -> Number>(
    "+" to { a, b -> a.toInt()+b.toInt() },
    "-" to { a, b -> a.toInt()-b.toInt() },
)

fun main() {
    println("Математический тренировщик")
    val answers = mutableListOf<Long>()
    var expressions = 0

    Scanner(System.`in`).use {
        while(true) {
            val a = Random.nextInt(999)
            val b = Random.nextInt(999)
            val operation = operations.entries.shuffled().first()
            val answer = operation.value(a, b)

            val startTime = System.currentTimeMillis()
            print("$a${operation.key}$b=")
            when(it.nextLine()) {
                ":quit", ":q" -> {

                    println("${answers.size} правельных ответов из $expressions")
                    if(answers.size==0)
                        println("Среднее время вычисления: ${answers.average()/1000L}с")
                    else println("Плохой из тебя математик")

                    break
                }

                answer.toString() -> {
                    val answerTime = System.currentTimeMillis() - startTime
                    answers.add(answerTime)

                    println("Правильный ответ. Вы ответили на пример за ${answerTime/1000L} секунды")
                }

                else -> {
                    println("Неверный ответ! $answer")
                }
            }

            expressions++
        }
    }
}