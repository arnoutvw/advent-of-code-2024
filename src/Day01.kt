fun main() {

    fun createLeftRightLists(input: List<String>): Pair<ArrayList<Int>, ArrayList<Int>> {
        val left = ArrayList<Int>()
        val right = ArrayList<Int>()
        input.forEach {
            val split = it.split("\\s+".toRegex())
            left.add(split[0].toInt())
            right.add(split[1].toInt())
        }
        left.sort()
        right.sort()
        return Pair(left, right)
    }

    fun part1(input: List<String>): Int {
        var totalDistance = 0;

        val (left, right) = createLeftRightLists(input)

        left.forEachIndexed { index, value ->
            totalDistance += Math.abs(value - right[index])
        }

        return totalDistance
    }

    fun part2(input: List<String>): Int {
        var totalSim = 0

        val (left, right) = createLeftRightLists(input)

        left.forEach { value ->
            totalSim += value * right.count{ it == value }
        }

        return totalSim
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
