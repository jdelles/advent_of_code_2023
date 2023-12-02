package day01

import java.io.File

fun main() {
    val file = File("src/main/kotlin/day01/Day01.txt")
    val lines = file.useLines { it.toList() }
    var sum = 0
    lines.forEach { line ->
        val matches = mutableListOf<Int>()
        line.forEach { c ->
            if (c.isDigit()) matches.add(c.digitToInt())
        }
        sum += matches.first() * 10 + matches.last()
    }
    println(sum)
}
