package com.enigmastation.advent

import kotlin.test.Test
import kotlin.test.assertEquals

enum class Result(val score: Int) {
    WIN(6),
    LOSE(0),
    DRAW(3)
}

enum class Move(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}

enum class Mapping(val move: Move, val result: Result? = null) {
    A(Move.ROCK),
    B(Move.PAPER),
    C(Move.SCISSORS),
    X(Move.ROCK, Result.LOSE),
    Y(Move.PAPER, Result.DRAW),
    Z(Move.SCISSORS, Result.WIN)
}


val results = mapOf(
    Pair(Move.ROCK, Move.PAPER) to Result.WIN,
    Pair(Move.ROCK, Move.SCISSORS) to Result.LOSE,
    Pair(Move.PAPER, Move.SCISSORS) to Result.WIN,
    Pair(Move.PAPER, Move.ROCK) to Result.LOSE,
    Pair(Move.SCISSORS, Move.ROCK) to Result.WIN,
    Pair(Move.SCISSORS, Move.PAPER) to Result.LOSE
)

fun getScore(p1: Move, p2: Move) =
    results.getOrDefault(Pair(p1, p2), Result.DRAW)

fun part1Mapping(p1: String, p2: String): Int {
    val m1 = Mapping.valueOf(p1).move
    val m2 = Mapping.valueOf(p2).move
    val res = getScore(m1, m2)

    return res.score + m2.score
}

fun findMoveWithResult(m: Move, r: Result): Move {
    return when (r) {
        Result.DRAW -> m
        else -> {
            results.filterValues { it == r }
                .filterKeys { it.first == m }
                .map { it.key }
                .map { it.second }
                .stream()
                .findFirst()
                .get()
        }
    }
}

fun part2Mapping(p1: String, p2: String): Int {
    val m1 = Mapping.valueOf(p1).move
    val m2 = Mapping.valueOf(p2).result!!

    return findMoveWithResult(m1, m2).score + m2.score
}

class Day02 {
    private fun convertToRounds(input: List<String>, transform: (String, String) -> Int): List<Int> =
        input.map {
            val (first, second) = it.split(" ")
            transform(first, second)
        }

    @Test
    fun validateMoves() {
        assertEquals(Result.DRAW, getScore(Move.ROCK, Move.ROCK))
        assertEquals(Result.WIN, getScore(Move.PAPER, Move.SCISSORS))
        assertEquals(Result.LOSE, getScore(Move.ROCK, Move.SCISSORS))
    }

    @Test
    fun validateOutcome() {
        assertEquals(8, part1Mapping("A", "Y"))
        assertEquals(1, part1Mapping("B", "X"))
        assertEquals(6, part1Mapping("C", "Z"))
    }

    @Test
    fun part1Test() {
        val input = readInput("day02/test")
        assertEquals(
            15,
            convertToRounds(input, ::part1Mapping)
                .sum()
        )
    }

    @Test
    fun part2Test() {
        val input = readInput("day02/test")
        assertEquals(
            12,
            convertToRounds(input, ::part2Mapping)
                .sum()
        )
    }


    @Test
    fun part1() {
        val input = readInput("day02/part1")
        println(
            "Part 1: " +
                    convertToRounds(input, ::part1Mapping)
                        .sum()
        )
    }

    @Test
    fun part2() {
        val input = readInput("day02/part1")
        println(
            "Part 1: " +
                    convertToRounds(input, ::part2Mapping)
                        .sum()
        )
    }

}
