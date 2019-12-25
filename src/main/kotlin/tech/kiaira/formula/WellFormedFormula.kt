package tech.kiaira.formula

import tech.kiaira.formula.WFFProperty

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2019-12-16
 */
class WellFormedFormula(var text: String) {

    /**
     * The proper initial segments for this well formed formula
     */
    val segments: ProperInitialSegment = ProperInitialSegment(this)


    /**
     * The first invalid character in the sequence
     */
    val invalidCharacter = verifyInput()

    /**
     * The construction sequence of this formula
     */
    var constructionSequence: ConstructionSequence? = null

    /**
     * Whether the sequence is valid or not
     */
    var validSequence: Boolean

    /**
     * Information about where the invalid segment occurred
     */
    var invalidSegmentInfo : String? = null

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

    init {
        validSequence = invalidCharacter == null
        if (validSequence) {
            constructionSequence = ConstructionSequence(this)
            constructionSequence!!.loadSequence()
        }
    }

    /**
     * This function verifies whether this formula satisfies all properties.
     * @return Int
     * The integer -1 is returned if all properties from {@link WFFProperty} are satisfied
     */
    public fun satisfiesProperties(): WFFProperty? {
        for (property in WFFProperty.values()) {
            if (!property.isSatisfied(this)) {
                return property
            }
        }
        return null
    }

}