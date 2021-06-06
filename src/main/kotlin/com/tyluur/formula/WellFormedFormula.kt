package com.tyluur.formula

import com.tyluur.formula.WFFProperty

/**
 * @author Tyluur <contact@tyluur.com>
 * @since 2019-12-16
 */
class WellFormedFormula(var text: String) {

    /**
     * The proper initial segments for this well formed formula
     */
    val segments: ProperInitialSegment = ProperInitialSegment(this)

    /**
     * The construction sequence of this formula
     */
    var sequence = ConstructionSequence(this)

    /**
     * The first invalid character in the sequence
     */
    val invalidCharacter = verifyInput()

    /**
     * Information about where the invalid segment occurred
     */
    var invalidSegmentInfo: String? = null

    /**
     * Verifying that the input of this well formed formula is acceptable
     * @return Char? The character that was unacceptable
     */
    private fun verifyInput(): Char? {
        this.text = text.trim()
        this.text = text.replace("\\s".toRegex(), "")
        for (char in text.chars()) {
            if (!WFFData.acceptableCharacter(char.toChar())) {
                return char.toChar()
            }
        }
        return null
    }

    /**
     * This function verifies whether this formula satisfies all properties.
     * @return Int
     * The integer -1 is returned if all properties from {@link WFFProperty} are satisfied
     */
    fun satisfiesProperties(): WFFProperty? {
        for (property in WFFProperty.values()) {
            if (!property.isSatisfied(this)) {
                return property
            }
        }
        return null
    }

    /**
     * If this formula is an atomic formula
     */
    fun isAtomic(): Boolean {
        return text.toCharArray().size == 1
    }

}