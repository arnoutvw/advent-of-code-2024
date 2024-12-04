import kotlin.math.abs

fun main() {

    fun isSafe(it: String) : Boolean {
        var up: Boolean? = null
        var char1 : Int = -1
        for (subit in it.split(" ")) {
            if (char1 != -1) {
                if(abs(char1 - subit.toInt()) < 1 || abs(char1 - subit.toInt()) > 3) {
                    return false
                }
                if (up == null) {
                    up = char1 < subit.toInt()
                } else {
                    if (up && char1 > subit.toInt() || !up && char1 < subit.toInt()) {
                        return false
                    }
                }
            }
            char1 = subit.toInt()
        }
        return true
    }

    fun part1(input: List<String>): Int {
        var safe = 0

        input.forEach {
            val safeCheck = isSafe(it)
            if(safeCheck) {
                safe++
            }

        }

        return safe
    }


    fun part2(input: List<String>): Int {
        var safe = 0

        input.forEach {
            val safeCheck = isSafe(it)
            if(safeCheck) {
                safe++
            } else {
                val lijst = it.split(" ").toList()
                for (i in 0 until lijst.size) {
                    val copyLijst = lijst.toMutableList()
                    copyLijst.removeAt(i)
                    if(isSafe(copyLijst.joinToString(" "))) {
                        safe++
                        break
                    }
                }
            }

        }

        return safe
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
