package com.enigmastation.advent

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.security.MessageDigest

class HiddenClass

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String):List<String> {
    return try {
        BufferedReader(
            InputStreamReader(
                HiddenClass::class.java.getResourceAsStream("/$name.txt")!!
            )
        ).readLines()
    } catch (e:Exception) {
        e.printStackTrace()
        emptyList()
    }
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
