package com.tyluur.formula

/**
 * @author Tyluur <itstyluur@icloud.com>
 *
 * This method verifies that the character is alphabetical
 * @return Boolean True if valid, false if not
 */
fun Char.isAlphabetical(): Boolean {
    return (this in 'a'..'z') || (this in 'A'..'Z')
}

/**
 * Replaces all input syntax that can be translated into WFF syntax
 * @return String The new string in WFF
 */
fun String.replaceWFFAlphabet(): String {
    var newString = this
    WFFData.NOT_REPLACEMENTS.forEach { replacement ->
        newString = newString.replace(replacement, "${WFFData.NOT}")
        newString = newString.replace(replacement.toLowerCase(), "${WFFData.NOT}")
    }
    WFFData.AND_REPLACEMENTS.forEach { replacement ->
        newString = newString.replace(replacement, "${WFFData.AND}")
        newString = newString.replace(replacement.toLowerCase(), "${WFFData.AND}")
    }
    WFFData.OR_REPLACEMENTS.forEach { replacement ->
        newString = newString.replace(replacement, "${WFFData.OR}")
        newString = newString.replace(replacement.toLowerCase(), "${WFFData.OR}")
    }
    WFFData.IMPLIES_REPLACEMENTS.forEach { replacement ->
        newString = newString.replace(replacement, "${WFFData.IMPLIES}")
        newString = newString.replace(replacement.toLowerCase(), "${WFFData.IMPLIES}")
    }
    return newString
}