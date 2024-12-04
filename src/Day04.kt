fun main() {

    var word = "XMAS"

    fun findRight(input: List<String>, x: Int, y: Int): Boolean {
        try {
            //right
            if (input[x].substring(y, y + word.length) == word) {
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun findLeft(input: List<String>, x: Int, y: Int): Boolean {
        try {
            if (input[x].substring(y - word.length + 1, y + 1) == word.reversed()) {
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun findUp(input: List<String>, x: Int, y: Int): Boolean {
        try {
            var upWord = listOf(0, 1, 2, 3).map { input[x - it][y] }.joinToString("")
            if (upWord == word) {
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun findDown(input: List<String>, x: Int, y: Int): Boolean {
        try {
            var downWord = listOf(0, 1, 2, 3).map { input[x + it][y] }.joinToString("")
            if (downWord == word) {
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun diag1(input: List<String>, x: Int, y: Int): Boolean {
        try {
            var leftUpWord = listOf(0, 1, 2, 3).map { input[x + it][y - it] }.joinToString("")
            if (leftUpWord == word) {
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun diag2(input: List<String>, x: Int, y: Int): Boolean {
        try {
            var rightUpWord = listOf(0, 1, 2, 3).map { input[x - it][y - it] }.joinToString("")
            if (rightUpWord == word) {
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun diag3(input: List<String>, x: Int, y: Int): Boolean {
        try {
            var leftdownWord = listOf(0, 1, 2, 3).map { input[x + it][y + it] }.joinToString("")
            if (leftdownWord == word) {
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun diag4(input: List<String>, x: Int, y: Int): Boolean {
        try {
            var rightDownWord = listOf(0, 1, 2, 3).map { input[x - it][y + it] }.joinToString("")
            if (rightDownWord == word) {
                return true
            }
        } catch (e: Exception) {
        }
        return false
    }

    fun findWord(x: Int, y: Int, input: List<String>): Int {
        var count = 0
        if (findRight(input, x, y)) count++
        //left
        if (findLeft(input, x, y)) count++
        //up
        if (findUp(input, x, y)) count++
        //down
        if (findDown(input, x, y)) count++

        //diagonal
        if (diag1(input, x, y)) count++
        if (diag2(input, x, y)) count++
        if (diag3(input, x, y)) count++
        if (diag4(input, x, y)) count++
        return count
    }

    fun part1(input: List<String>): Int {
        var total = 0

        input.forEachIndexed { x, line ->
            line.forEachIndexed { y, char ->
                if (char == 'X') {
                    var found = findWord(x, y, input)
                    if(found > 0) {
                        //"Starting location $x $y $found".println()
                        total+=found
                    }
                }
            }
        }

        return total
    }


    fun isPartOfMas(input: List<String>, x: Int, y: Int): String {
        return input[x][y].toString()
    }

    fun checkX(x: Int, y: Int, input: List<String>): Int {
        if(x > 0 && y > 0 && x < input.size-1 && y < input[x].length-1) {
            val one = isPartOfMas(input, x - 1, y - 1) + isPartOfMas(input, x + 1, y + 1)
            val two = isPartOfMas(input, x+1, y-1) + isPartOfMas(input, x-1, y+1)
            if((one.equals("MS") || one.equals("SM"))
                && (two.equals("MS") || two.equals("SM"))) {
                return 1
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        var total = 0

        input.forEachIndexed { x, line ->
            line.forEachIndexed { y, char ->
                if (char == 'A') {
                    var found = checkX(x, y, input)
                    if(found > 0) {
                        "Starting location $x $y $found".println()
                        total+=found
                    }
                }
            }
        }

        return total
    }

    // Or read a large test input from the `src/Day04_test.txt` file:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    // Read the input from the `src/Day04.txt` file.
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
