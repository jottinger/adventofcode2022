package com.enigmastation.advent

import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import kotlin.test.assertEquals

data class Rucksack(val contents: String) {
    fun items(): CharArray = contents.toCharArray()
}

class Day03 {
    private fun priority(type: Char) =
        type.lowercaseChar().code -
                'a'.code +
                when (type.isLowerCase()) {
                    true -> 1
                    else -> 27
                }

    @DataProvider
    fun letterPriorities(): Array<Array<Any>> {
        return arrayOf(
            arrayOf(16, 'p'),
            arrayOf(38, 'L'),
            arrayOf(42, 'P'),
            arrayOf(22, 'v'),
            arrayOf(20, 't'),
            arrayOf(19, 's')
        )
    }

    @Test(dataProvider = "letterPriorities")
    fun testLetterPriority(priority: Int, letter: Char) {
        assertEquals(priority, priority(letter))
    }

    @Test
    fun buildRucksacks(name: String = "day03/test"): List<Pair<Rucksack, Rucksack>> {
        val input = readInput(name)
        return input.map {
            val first = it.substring(0, it.length / 2)
            val second = it.substring(first.length)
            Pair(Rucksack(first), Rucksack(second))
        }.also { println(it) }
    }


    @Test
    fun part1() {
        val data = buildRucksacks("day03/actual")
        println("part 1: " +
                data.sumOf {
                    priority(
                        it
                            .first
                            .items()
                            .intersect(
                                it
                                    .second
                                    .items()
                                    .asIterable()
                                    .toSet()
                            )
                            .first()
                    )
                }
        )
    }

    @Test
    fun part2() {
        val data = buildRucksacks("day03/actual")
        val groups: MutableList<Set<Char>> = mutableListOf()
        var priorities: MutableList<Int> = mutableListOf()
        var commons: Set<Char> = mutableSetOf()
        var counter = 0
        data.forEach {
            val group = it.first.items().toMutableSet()
            group.addAll(it.second.items().toSet())
            counter++
            when (counter) {
                1 -> commons = group
                2 -> commons = commons.intersect(group)
                else -> {
                    commons = commons.intersect(group)
                    priorities.add(priority(commons.first()))
                    counter = 0
                }
            }
        }
        println("part 2: "+priorities.sum())
    }
}
