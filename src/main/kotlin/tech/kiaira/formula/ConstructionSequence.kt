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
        // TODO: design an algorithm
        /*
        Idea:
        while (brackets exist in text)
            index of current bracket
            index of last bracket
            add that to list
            remove those brackets
         */
        // TODO: idea 2
        /*
            (use a tree for a design)
            start at index 0, must be a '('
                cases:
                everything following that we're at index with number of RB = #LB
                add this to the top of the tree (identified by the operator)
                    operator identification
                        either next to the bracket or between
                remove the bracket
         */
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
        //  [¬, ∧, ∨, →]
/*        var text = "" + formula.text
        var index = 0
        while (text.contains("(") && text.contains(")")) {
            val toCharArray = text.toCharArray()
            var currChar = toCharArray[index]
            // can be right or left
            val rightBracketCount = text.bracketCount(left = false)
            // we must be on the open left bracket
            if (currChar != '(') {
                continue
            }
            // if we have no right brackets left, we're done
            if (rightBracketCount == 0) {
                break
            }
            println("text=$text, rightBracketCount=$rightBracketCount")
            val expectedNotIndex = index + 1
            var trimIndex = 1
            // next char to the left bracket is
            if (expectedNotIndex < toCharArray.size && toCharArray[expectedNotIndex] == WFFData.NOT) {
                trimIndex++
            }
            text = text.substring(index + trimIndex, toCharArray.lastIndex)
            println(text)
        }*/
        /* val text = formula.text
         val chars = text.toCharArray()
         val connectiveSplit = arrayOf<String>()
         // priority sequence: [∧, ∨, →]
         val connectiveVariables: List<String> = emptyList()
         for ((index, char) in chars.withIndex()) {
             // x left brackets =
             if (char == '(') {
                 var substring = text.substring(index + 1)
                 val expectedRightBracket = substring.count { c -> c == ')' }
                 innerLoop@ for ((index2, char2) in chars.withIndex()) {
                     if (index2 <= index)
                         continue@innerLoop
                     var rightBracketIndex = 0;
                     if (char2 == '(') {
                         rightBracketIndex++
                         if (rightBracketIndex == expectedRightBracket) {
                             substring = text.substring(index + 1, index2)
                         }
                         println("$index, $index2, ${chars.lastIndex}, $char, $substring, $expectedRightBracket, ${text.substring(index, index2)}")
                     }
                 }
             }
         }*/
    }

}

