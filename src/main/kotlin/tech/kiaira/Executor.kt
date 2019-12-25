package tech.kiaira

import tech.kiaira.formula.WellFormedFormula

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2019-12-16
 */
class Executor {

    fun main(args: Array<String>) {
/*    print("Enter the formula you wish to validate:\t")
    val input = TextIO.getlnString()*/
        val inputs = arrayListOf<String>(/*"(a Λ b)", "a", "¬(a)", "(a)))", "((¬(a Λ b)) → (b Λ a)) → (¬a)"*/ "(¬((a → b) → (b → c)))")
        for (input in inputs) {
            println("Validating sequence: [$input]...")
            val formula = WellFormedFormula(input)
            val invalidCharacter = formula.invalidCharacter
            if (invalidCharacter != null) {
                println("The input you entered contained an invalid character: [$invalidCharacter]")
                return
            }
            formula.segments.showSegments()
            val satisfiesProperties = formula.satisfiesProperties()
            if (satisfiesProperties != null) {
                println("\tUnable to satisfy property '$satisfiesProperties'" + (if (formula.invalidSegmentInfo != null) "\tDetails:\t${formula.invalidSegmentInfo}" else ""))
                continue
            }
            println("\tInput was verified and properties were passed")
        }

    }
}