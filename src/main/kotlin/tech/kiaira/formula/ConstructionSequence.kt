package tech.kiaira.formula

import tech.kiaira.util.bracketCount
import tech.kiaira.util.variableIndexOfCharacter

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2019-12-16
 */
class ConstructionSequence(private val formula: WellFormedFormula) {

    /**
     * This list contains each construction sequence of the formula
     */
    val set = mutableSetOf<String>()

    fun loadSequence() {
        addVariables()
        addConnectiveVariables()
        println("\tConstruction sequence:$set")
    }

    /**
     * Adding all the variables from the sequence into
     */
    private fun addVariables() {
        val chars = formula.text.toCharArray()
        for ((index, char) in chars.withIndex()) {
            if ((char.isAlphabetical())) {
                set.add("$char")
                // the not operator will either be right next to the variable or next to the bracket next to the variable
                notLoop@ for (i in 1..2) {
                    val expectedIndex = index - i
                    if (expectedIndex >= 0) {
                        val itemAtExpected = chars[expectedIndex]
                        if (itemAtExpected == WFFData.NOT) {
                            set.add("(" + WFFData.NOT + "$char)")
                            break@notLoop
                        }
                    }
                }
            }
        }
    }

    /**
     * This method finds all the connectives and populates the construction sequence set with them
     */
    private fun addConnectiveVariables() {
        //  [¬, ∧, ∨, →]
        var text = formula.text
        var index = 0
        while (text.contains("(") && text.contains(")")) {
            println("[SOF]\ttext='$text'")
            val toCharArray = text.toCharArray()
            if (index >= toCharArray.size) {
                println("bad index")
                break
            }
            var currChar = toCharArray[index]
            // can be right or left
            val rightBracketCount = text.bracketCount(left = false)
            // we must be on the open left bracket
            if (currChar != '(') {
                println("not bracket: '$currChar'")
                break
            }
            // if we have no right brackets left, we're done
            if (rightBracketCount == 0) {
                println("rbc = 0")
                break
            }
            var operator : Char;
            var trimIndex = 1
            val expectedNotIndex = index + 1
            // next char to the left bracket is
            if (expectedNotIndex < toCharArray.size && toCharArray[expectedNotIndex] == WFFData.NOT) {
                operator = WFFData.NOT
                trimIndex++
            }
            // find the index of the nth right bracket
            val indexOfRightBracket = text.variableIndexOfCharacter(')', rightBracketCount)
            text = text.substring(trimIndex, indexOfRightBracket).trim()
            println("[EOF]\ttext='$text' rightBracketCount='$rightBracketCount', indexOfRightBracket='$indexOfRightBracket'")
        }
    }

}

