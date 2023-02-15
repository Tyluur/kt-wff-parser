package com.tyluur.formula

import java.lang.StringBuilder

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since 2019-12-16
 */
class ProperInitialSegment(private val formula: WellFormedFormula) {

    /**
     * This list contains each proper inital segment of the formula
     */
    val list = mutableListOf<String>()

    init {
        createSegments()
    }

    /**
     * This method creates all possible initial segments
     */
    private fun createSegments() {
        val chars = formula.text.chars().toArray()
        val builder = StringBuilder()
        for ((index, char) in chars.withIndex()) {
            if (index == chars.lastIndex) {
                break
            }
            builder.append(char.toChar())
            val element = builder.toString()
            list.add(element)
        }
    }

    /**
     * Printing all the initial segments
     */
    fun getPrettySegments() : String {
        val bldr = StringBuilder()
        for ((index, it) in list.withIndex()) {
            bldr.append(it + (if (index == list.lastIndex) "" else ", "))
        }
        return "[${bldr.toString()}]"
    }



}