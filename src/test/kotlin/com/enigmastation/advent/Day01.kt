package com.enigmastation.advent

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01() {
    private fun convertToElves(input: List<String>): List<Elf> {
        val elves: MutableList<Elf> = mutableListOf()
        val calories: MutableList<Int> = mutableListOf()
        input.stream().forEach {
            if (it.trim() == "") {
                elves += Elf(calories.toList())
                calories.clear()
            } else {
                calories += it.trim().toInt()
            }
        }
        return elves
    }

    private fun topElf(input: List<Elf>): Int {
        return input
            .map { it.totalCalories() }
            .maxOf { it }
    }

    private fun topThreeElves(input: List<Elf>): Int {
        return input
            .map { it.totalCalories() }
            .sorted()
            .reversed()
            .subList(0, 3)
            .sum()
    }

    @Test
    fun part1Test() {
        val elves = convertToElves(readInput("day01/test"))
        assertEquals(24000, topElf(elves))
    }

    @Test
    fun part1Real() {
        val elves = convertToElves(readInput("day01/actual"))
        println(topElf(elves))
    }

    @Test
    fun part2Real() {
        val elves = convertToElves(readInput("day01/actual"))
        println(topThreeElves(elves))
    }
}
