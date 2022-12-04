package com.enigmastation.advent.day04

import com.enigmastation.advent.readInput
import org.testng.annotations.Test

class Day04 {
    fun convertToRange(v:String): Set<Int> {
        val input=v.split("-").map { it.toInt() }
        return IntRange(input[0], input[1]).toSet()
    }

    fun convertLineToRanges(v:String): Pair<Set<Int>, Set<Int>> {
        val input=v.split(",")
        return Pair(convertToRange(input[0]), convertToRange(input[1]))
    }

    @Test
    fun part1() {
        val input= readInput("day04/actual")
        var subsumptions=0
        input
            .map { convertLineToRanges(it)}
            .forEach {
                if(it.first.containsAll(it.second) ||
                    it.second.containsAll(it.first)) {
                    subsumptions++
                }
            }
        println("part1: subsumptions = "+subsumptions)
    }
    @Test
    fun part2() {
        val input= readInput("day04/actual")
        var overlaps=0
        input
            .map { convertLineToRanges(it)}
            .forEach {
                if(it.first.intersect(it.second).isNotEmpty() ||
                    it.second.intersect(it.first).isNotEmpty()
                ) {
                    overlaps++
                }
            }
        println("part2: overlaps = "+overlaps)
    }
}
