package day02

import java.io.File

fun main() {
    val file = File("src/main/kotlin/day02/Day02.txt")
    val lines = file.useLines { it.toList() }
    var sum = 0
    val colorMaxMap = mapOf(
        "red" to 12,
        "green" to 13,
        "blue" to 14,
    )
    lines.forEach {  line ->
        var isValidInput = true
        val parts = line.split(":")
        val gameNumber = parts[0].split(" ")[1].trim().toInt()
        val colorCountList = parts[1].trim().split(";").map { it.trim() }
        colorCountList.forEach { colorCountListItem ->
            val values = colorCountListItem.split(",").map { it.trim() }
            values.forEach { value ->
                val countToColor = value.split(" ").map { it.trim() }
                if (countToColor[0].toInt() > colorMaxMap[countToColor[1]] as Int) isValidInput = false
            }
        }
        if (isValidInput) sum += gameNumber
    }
    println(sum)
}