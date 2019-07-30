fun main() {

    println(solve(intArrayOf(9, 3, 9, 3, 9, 7, 11, 9, 7)))
}

private fun solve(array: IntArray): Int {
    val set = hashSetOf<Int>()
    array.forEach(set::execute)
    return set.first()
}

private fun HashSet<Int>.execute(value: Int) {
    if (contains(value))
        remove(value)
    else add(value)
}


private tailrec fun IntArray.solve(index: Int = 0): Int =
    if (index == lastIndex || findPair(get(index)).not())
        get(index)
    else solve(index + 1)

private tailrec fun IntArray.findPair(target: Int, index: Int = 0, count: Int = 0): Boolean =
    if (index == size)
        count % 2 == 0
    else findPair(target, index + 1, if (get(index) == target) count + 1 else count)