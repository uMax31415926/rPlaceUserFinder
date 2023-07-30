/*
 * Copyright (c) 2023 u/Max31415926
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

import java.nio.file.Files
import java.nio.file.Path

class Area(private val startX: Int, private val startY: Int,
           private val endX: Int, private val endY: Int) {
	fun contains(x: Int, y: Int): Boolean {
		return x in startX..endX && y in startY .. endY
	}
}

fun main() {
	// read areas from file
	val areas = buildList<Area> {
		Path.of("areas.txt").toFile().forEachLine {
			val coordinates = it.split(",")
			add(Area(coordinates[0].toInt(), coordinates[1].toInt(),
				coordinates[2].toInt(), coordinates[3].toInt()))
		}
	}

	// create one set of user IDs per area
	val userSets = buildList<MutableSet<String>> {
		areas.forEach {
			add(mutableSetOf())
		}
	}

	// locate all CSV files
	val paths = Files.walk(Path.of(""))
		.filter { file -> file.toString().endsWith(".csv") }
		.sorted()
		.toList()

	for (path in paths) {
		println("Scanning $path...")
		path.toFile().forEachLine {
			val columns = it.split(",")
			val user = columns[1]
			val x = columns[2].drop(1).toIntOrNull()
			val y = columns[3].dropLast(1).toIntOrNull()

			if (x == null || y == null)
				// skip first line and some malformed lines
				return@forEachLine

			for (i in areas.indices) {  // check each line for each area
				if (areas[i].contains(x, y))
					userSets[i].add(user)
			}
		}
	}

	// intersect sets to determine users that have placed a pixel in each area
	val users = userSets.reduce { acc, next ->
		(acc intersect next).toMutableSet()
	}

	println()
	println("Found the following users:")
	users.forEach { println(it) }
	println()
	println("Found ${users.size} users in total.")
}
