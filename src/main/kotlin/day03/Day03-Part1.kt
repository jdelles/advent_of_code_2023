package day03

import java.io.File


fun main() {
    val file = File("/Users/jamesdelles/Code/Advent_Of_Code_2023/src/main/kotlin/day03/Day03.txt")
    val rows = file.useLines { it.toList().map { it1 -> it1.toList() } }
    var sum = 0
    for (i in rows.indices) {
        val regex = Regex("\\d+")
        val matches = regex.findAll(rows[i].joinToString("")).toList()
        for (match in matches) {
            val startIndex = match.range.first
            val endIndex = match.range.last
            if (isAdjacentToSymbol(i, startIndex, endIndex, rows)) {
                val number = match.value
                println(number.toInt())
                sum += number.toInt()
            }
        }
    }
    println("Sum of part numbers: $sum")
}


fun isAdjacentToSymbol(i: Int, startIndex: Int, endIndex: Int, grid: List<List<Char>>): Boolean {
    val number = grid[i].subList(startIndex, endIndex + 1).joinToString("")
    return number.any { c ->
        val adjacentChars = mutableListOf(
            Pair(i, startIndex - 1),
            Pair(i, endIndex + 1),
        )
        val startRange = startIndex - 1
        val endRange = endIndex + 1
        for (col in startRange..endRange) {
            adjacentChars.add(Pair(i - 1, col))
            adjacentChars.add(Pair(i + 1, col))
        }
        adjacentChars.any { (row, col) ->
            row in grid.indices && col in grid[row].indices && grid[row][col] != '.'
        }
    }
}