package com.tyluur.util

/**
 * This function counts the amount of brackets in a string, whether left or right
 * @receiver String The string
 * @param left Boolean The boolean
 * @return Int
 */
fun String.bracketCount(left: Boolean): Int {
    return countCharAmount(if (left) '(' else ')');
}

/**
 * This function counts the amount of characters in a string
 * @param charToIdentify Char The character to count
 */
fun String.countCharAmount(charToIdentify: Char): Int {
    var count: Int = 0
    for (char in chars()) {
        if (char.toChar() == charToIdentify) {
            count++
        }
    }
    return count
}

/**
 * This function finds the nth existence of a character in a String
 * @return Int
 */
fun String.variableIndexOfCharacter(charToIdentify: Char, amount: Int): Int {
    var count: Int = 0
    for ((index, char) in chars().toArray().withIndex()) {
        if (char.toChar() == charToIdentify) {
            count++
            if (count == amount) {
                return index
            }
        }

    }
    return -1
}