import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val world1 = arrayOf(
        arrayOf(1, 1, 0, 1),
        arrayOf(1, 1, 0, 1),
        arrayOf(1, 0, 1, 1),
        arrayOf(1, 1, 1, 1)
    )
    val world2 = arrayOf(
        arrayOf(1, 1, 1, 1),
        arrayOf(1, 1, 0, 1),
        arrayOf(1, 0, 0, 1),
        arrayOf(1, 1, 1, 1)
    )
    val world3 = arrayOf(
        arrayOf(1, 1, 0, 1),
        arrayOf(1, 0, 0, 1),
        arrayOf(1, 0, 1, 1),
        arrayOf(1, 1, 1, 1)
    )
    val world4 = arrayOf(
        arrayOf(1, 1, 0, 1, 1, 1 ,1, 1, 1, 1 ,1, 1),
        arrayOf(1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0),
        arrayOf(1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1),
        arrayOf(0, 1, 1, 0, 1, 1, 0, 0, 1, 0 ,1, 1),
        arrayOf(1, 1, 1, 0, 0, 1, 0, 1, 1, 0 ,1, 1),
        arrayOf(1, 1, 1, 0, 1, 1, 1, 1, 1, 0 ,1, 1)
    )

    println("input")
    printWorld(world1)
    println("output")
    var newWorld = searchForZero(world1)
    printWorld(newWorld)
    println("input")
    printWorld(world2)
    println("output")
    newWorld = searchForZero(world2)
    printWorld(newWorld)
    println("input")
    printWorld(world3)
    println("output")
    newWorld = searchForZero(world3)
    printWorld(newWorld)
    println("input")
    printWorld(world4)
    println("output")
    newWorld = searchForZero(world4)
    printWorld(newWorld)
}

fun printWorld(world: Array<Array<Int>>) {
    for (row in 0..world.size - 1) {
        for (col in 0..world[0].size - 1) {
            print(world[row][col])
        }
        println("")
    }
    println("---------------------------")
}

fun searchForZero(world: Array<Array<Int>>): Array<Array<Int>> {
    for(row in 0..world.size -1) {
        for (col in 0..world[0].size - 1) {
            if (world[row][col] == 0) {
                fillIsland(world, row, col)
            }
        }
    }
    return world
}

fun fillIsland(world: Array<Array<Int>>, row: Int, col: Int) {
    // our visited island cells, don't revisit these
    val visited: HashSet<String> = HashSet()

    // our current list of island cells to test
    val list: Stack<Pair<Int,Int>> = Stack()

    // our island cells that we have to paint
    val toPaint: MutableList<Pair<Int,Int>> = mutableListOf()

    list.push(Pair(row, col))
    while(list.size > 0) {
        val currentCell = list.pop()

        // if we encounter an island cell that is on a row or col border, return since this is not part of the island
        // to fill, returning now will also not paint the existing cells since these are connected to the border cell
        if (currentCell.first == 0 || currentCell.second == 0 || currentCell.first == world.size - 1 || currentCell.second == world[0].size - 1) {
            return
        }
        visited.add("${currentCell.first},${currentCell.second}")
        toPaint.add(Pair(currentCell.first,currentCell.second))

        if (!visited.contains("${currentCell.first + 1},${currentCell.second}") && world[currentCell.first + 1][currentCell.second] == 0) {
            list.add(Pair(currentCell.first + 1, currentCell.second))
        }
        if (!visited.contains("${currentCell.first - 1},${currentCell.second}") && world[currentCell.first - 1][currentCell.second] == 0) {
            list.add(Pair(currentCell.first - 1, currentCell.second))
        }
        if (!visited.contains("${currentCell.first},${currentCell.second + 1}") && world[currentCell.first][currentCell.second + 1] == 0) {
            list.add(Pair(currentCell.first, currentCell.second + 1))
        }
        if (!visited.contains("${currentCell.first},${currentCell.second - 1}") && world[currentCell.first][currentCell.second - 1] == 0) {
            list.add(Pair(currentCell.first, currentCell.second - 1))
        }
    }
    // paint the island cells that we found, these are enclosed in the island
    for(cell in toPaint) {
        world[cell.first][cell.second] = 1
    }
}