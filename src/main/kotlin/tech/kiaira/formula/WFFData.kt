package tech.kiaira.formula
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
        const val LEFT_BRACKET = '('
        const val RIGHT_BRACKET = ')'

        /**
         * The array of all possible connectives
         */
        val CONNECTIVES = charArrayOf(NOT, AND, OR, IMPLIES, LEFT_BRACKET, RIGHT_BRACKET)

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

/**
 * This method verifies that the character is alphabetical
 * @return Boolean True if valid, false if not
 */
fun Char.isAlphabetical(): Boolean {
    return (this in 'a'..'z') || (this in 'A'..'Z')
}

/**
 * Checking if this character represents a connective
 */
fun Char.isConnective(): Boolean {
    if (WFFData.CONNECTIVES.contains(this)) {
        return true
    }
    return false
}

