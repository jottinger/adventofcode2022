package com.enigmastation.advent

data class Elf(val calories: List<Int>) {
    fun totalCalories(): Int {
        return calories.sum()
    }

    override fun toString(): String {
        return calories.toString()+" (total: "+totalCalories()+")"
    }
}
