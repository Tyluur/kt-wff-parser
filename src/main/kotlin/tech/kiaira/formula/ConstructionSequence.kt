package tech.kiaira.formula

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2019-12-16
 */
class ConstructionSequence(private val formula: WellFormedFormula) {

    /**
     * This list contains each construction sequence of the formula
     */
    val set = mutableSetOf<String>()

    /**
     * Parses the formula and populates the sequence
     */
    fun loadSequence(): ConstructionSequence {
        addVariables()
        parseFormula()
        return this
    }

    /**
     * This method prints the data in [set], which is the construction sequence (in order)
     */
    fun printSequence() {
        println("Construction sequence:$set")
    }

    /**
     * This method finds all the connectives and populates the construction sequence set with them
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
                            set.add(WFFData.NOT + "$char")
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
    private fun parseFormula() {
        var bracketDefinedList = collectContentReversed(formula.text)
        bracketDefinedList = bracketDefinedList.asReversed()
        bracketDefinedList.forEach {
            set.add("($it)")
        }
    }

    /**
     * This method parses an input and collects all the items inside the brackets recursively
     * @param value String
     * @return List<String>
     */
    fun collectContentReversed(value: String): List<String> {
        if (!value.contains(")")) {
            return listOf(value)
        }
        val list = mutableListOf<String>()
        //Calculate the end of the first bracket (first in reverse order)
        var startIndex = value.lastIndexOf(")")
        var count = 0
        //Process each character right to left
        val chars = value.toCharArray()
        for (index in chars.size - 1 downTo 0) {
            val c = chars[index]
            if (c == ')') {
                //Keep track opening brackets
                count++
            } else if (c == '(') {
                //Keep track of  closing brackets
                count--
                //If we reach the beginning of a complete bracket
                if (count == 0) {
                    //Grab the brackets contents
                    val content = value.substring(index + 1, startIndex)
                    //Log it
                    list.add(content)
                    //If contents has brackets, process recursively
                    if (content.contains(")")) {
                        collectContentReversed(content).forEach {
                            list.add(it)
                        }
                    }
                    //Calculate the beginning of the next bracket
                    startIndex = value.lastIndexOf(")", index)
                }
            }

        }
        return list
    }


}

