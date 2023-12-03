package day02

import java.io.File

fun main() {
    val file = File("src/main/kotlin/day02/Day02.txt")
    val lines = file.useLines { it.toList() }
    var sum = 0
    lines.forEach { line ->
        var redMax = 0
        var greenMax = 0
        var blueMax = 0
        val parts = line.split(":")
        val colorCountList = parts[1].trim().split(";").map { it.trim() }
        colorCountList.forEach { colorCountListItem ->
            val values = colorCountListItem.split(",").map { it.trim() }
            values.forEach { value ->
                val countToColor = value.split(" ").map { it.trim() }
                val count = countToColor[0].toInt()
                val color = countToColor[1]
                when (color) {
                    "red" ->  {
                        if (count > redMax) redMax = count
                    }
                    "green" -> {
                        if (count > greenMax) greenMax = count
                    }
                    "blue" -> {
                        if (count > blueMax) blueMax = count
                    }
                }
            }
        }
        sum += redMax * greenMax * blueMax
    }
    println(sum)
}
