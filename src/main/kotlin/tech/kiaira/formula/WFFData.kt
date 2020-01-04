package tech.kiaira.formula

import tech.kiaira.formula.operations.FormulaOperation
import tech.kiaira.formula.operations.impl.ConnectiveOperation
import tech.kiaira.formula.operations.impl.NotOperation
import kotlin.reflect.KClass

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2019-12-16
 */
class WFFData {

    companion object {

        const val NOT = '¬'
        const val AND = 'Λ'
        const val OR = 'ν'
        const val IMPLIES = '→'
        private const val LEFT_BRACKET = '('
        private const val RIGHT_BRACKET = ')'

        /**
         * The array of all possible connectives
         */
        val CONNECTIVES = charArrayOf(NOT, AND, OR, IMPLIES, LEFT_BRACKET, RIGHT_BRACKET)

        /**
         * The user-input strings that will be translated [NOT]
         */
        val NOT_REPLACEMENTS = arrayOf("NOT", "WEDGE")

        /**
         * The user-input strings that will be translated [AND]
         */
        val AND_REPLACEMENTS = arrayOf("AND", "/\\")

        /**
         * The user-input strings that will be translated [OR]
         */
        val OR_REPLACEMENTS = arrayOf("OR", "\\/")

        /**
         * The user-input strings that will be translated [IMPLIES]
         */
        val IMPLIES_REPLACEMENTS = arrayOf("IMPLIES", "->")

        /**
         * This method verifies that the character is acceptable
         * @param character Char The character to check for
         * @return Boolean True if valid, false if not
         */
        fun acceptableCharacter(character: Char): Boolean {
            return character.isAlphabetical() || (CONNECTIVES.contains(character))
        }

    }

}