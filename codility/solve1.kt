private fun main() {
    println(makeBinaryCountArray(1041).getMaxLength())
}

private tailrec fun Array<Int>.getMaxLength(result: Int = 0): Int =
    if (size < 2)
        result
    else {
        val length = diffNext(0)
        copyOfRange(1, lastIndex).getMaxLength(
            if (length > result)
                length - 1
            else result
        )
    }

private fun Array<Int>.diffNext(index: Int) = get(index) - get(index + 1)

private tailrec fun makeBinaryCountArray(target: Int, array: Array<Int> = arrayOf()): Array<Int> =
    target.divBinary().let { count ->
        return when (count) {
            0 -> array
            1 -> array + arrayOf(0)
            else -> makeBinaryCountArray(target - pow(count), array + arrayOf(count))
        }
    }

private tailrec fun Int.divBinary(count: Int = 0): Int =
    when {
        this / 2 != 0 -> this.div(2).divBinary(count + 1)
        else -> count
    }

private tailrec fun pow(count: Int, result: Int = 0): Int =
    if (count == 0)
        result
    else pow(count - 1, 2 * if (result == 0) 1 else result)
