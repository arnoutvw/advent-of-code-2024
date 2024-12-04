fun main() {

    fun part1(input: List<String>): Int {
        var total = 0

        input.forEach { line ->
            "mul\\((\\d+),(\\d+)\\)".toRegex().findAll(line).toList().forEach {
                total += it.groupValues[1].toInt() * it.groupValues[2].toInt()
            }
        }

        return total
    }


    fun part2(input: List<String>): Int {
        var total = 0

        val joinToString = input.joinToString("")

        "mul\\((\\d+),(\\d+)\\)".toRegex().findAll(joinToString).toList().forEach {
            val currentBuffer = joinToString.substring(0, it.range.first)
            val doIndex = currentBuffer.lastIndexOf("do()")
            val dontIndex = currentBuffer.lastIndexOf("don't()")
            if((doIndex == -1 && dontIndex == -1) || doIndex > dontIndex) {
                total += it.groupValues[1].toInt() * it.groupValues[2].toInt()
            }
        }

        return total
    }

    // Or read a large test input from the `src/Day03_test.txt` file:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
