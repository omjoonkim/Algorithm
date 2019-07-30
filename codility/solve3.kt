fun main() {
    print(solve(intArrayOf(), 2).fold("") { acc, t -> acc + t.toString() })
}

private fun solve(array: IntArray, count: Int): IntArray = array.rotate(
    if (array.size > count)
        count
    else count % array.size
)

private fun IntArray.rotate(count: Int) = IntArray(size) { index ->
    val diff = index - count
    get(if (diff < 0) size + diff else diff)
}