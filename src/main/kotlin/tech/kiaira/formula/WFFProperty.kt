package tech.kiaira.formula

import tech.kiaira.util.bracketCount

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2019-12-16
 */
enum class WFFProperty {

    /** Every WFF is either atomic (an element of the core set) or starts with the left bracket symbol '(' */
    ATOMIC_OR_BRACKET_START {
        override fun isSatisfied(formula: WellFormedFormula): Boolean {
            val chars = formula.text.chars()
            // atomic
            val toArray = chars.toArray()
            // input is length of 1, it can only be a variable, no connectives allowed
            if (toArray.size == 1) {
                val firstChar = toArray[0].toChar()
                return (firstChar in 'a'..'z') || (firstChar in 'A'..'Z')
            } else {
                val firstChar = toArray[0].toChar()
                if (firstChar != '(')
                    return false
            }
            return true
        }
    },

    /** In every WFF, the number of left brackets '(' is equal to the number of right brackets ')' */
    BRACKET_EQUIVALENCE {
        override fun isSatisfied(formula: WellFormedFormula): Boolean {
            val leftBracketCount = formula.text.bracketCount(left = true)
            val rightBracketCount = formula.text.bracketCount(left = false)
            return leftBracketCount == rightBracketCount
        }
    },

    /** In every proper initial segment of a WFF, the number of left brackets '(' is strictly larger than the number of right bracket */
    PROPER_INITIAL_SEGMENT_BRACKET_PROPORTIONALITY {
        override fun isSatisfied(formula: WellFormedFormula): Boolean {
            for (segment in formula.segments.list) {
                val leftBracketCount = segment.bracketCount(left = true)
                val rightBracketCount = segment.bracketCount(left = false)
                if (leftBracketCount <= rightBracketCount) {
                    formula.invalidSegmentInfo = segment
                    return false
                }
            }
            return true
        }
    };

    abstract fun isSatisfied(formula: WellFormedFormula): Boolean;
}