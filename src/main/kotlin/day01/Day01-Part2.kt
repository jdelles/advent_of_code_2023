package day01

import java.io.File

fun main() {
    val file = File("src/main/kotlin/day01/Day01.txt")
    val lines = file.useLines { it.toList() }
    var sum = 0

    val digitMap = mapOf(
        "zero" to 0,
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    )

    lines.forEach { line ->
        val matches = mutableListOf<Int>()
        line.forEachIndexed { i, c ->
            if (c.isDigit()) matches.add(c.digitToInt())
            else {
                digitMap.keys.forEach { key ->
                    if (line.substring(i).startsWith(key)) {
                        matches.add(digitMap[key]!!)
                    }
                }
            }
        }
        sum += matches.first() * 10 + matches.last()
    }
    println(sum)
}

