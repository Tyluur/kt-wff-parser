package com.tyluur

import com.tyluur.formula.WellFormedFormula
import com.tyluur.formula.replaceWFFAlphabet
import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

/**
 * The reader instance used to read from the console
 */
private val reader = Scanner(System.`in`)

class Executor {

    /**
     * The main function invoked at program start time
     */
    fun launch() {
        println("Welcome to kotlin-wff-parser.\nGo over the README file for clarification on valid inputs.\n")

        while (true) {
            lateinit var input: String
            try {
                input = requestInput()
                while (!processAndValidateInput(input)) {
                    System.err.println("Invalid input, please try again...\n")
                    input = requestInput()
                }
                println("Validating input '$input'\n")

                val formula = WellFormedFormula(input)
                val invalidCharacter = formula.invalidCharacter
                if (invalidCharacter != null) {
                    System.err.println("The input you entered contained an invalid character: [$invalidCharacter]")
                    return
                }
                val satisfiesProperties = formula.satisfiesProperties()
                if (satisfiesProperties != null) {
                    System.err.println("Unable to satisfy property '$satisfiesProperties'" + (if (formula.invalidSegmentInfo != null) "\tDetails:\t${formula.invalidSegmentInfo}" else ""))
                    return
                }
                formula.sequence.loadSequence()
                println("Input was verified and properties were passed!")
                println("\tProper Initial Segments:\t${formula.segments.getPrettySegments()}")
                println("\tConstruction Sequence:\t${formula.sequence.set}\n")
            } catch (e: Exception) {
                System.err.println("There was an error in this calculation, please verify your input is correct.\nContact the developer over mail at contact@tyluur.com in the case of a bug")
                e.printStackTrace()
                break
            }
        }

    }

    /**
     * This method is used to request input from the console
     * @return String
     */
    private fun requestInput(): String {
        println("Please enter a desired well-formed-formula (You may also use 'exit' to quit this program):")
        return reader.nextLine().trim().lowercase().replaceWFFAlphabet()
    }

    /**
     * This makes sure the input is valid (not a blank string), or a termination string.
     * @return Boolean True if we should quit
     */
    private fun processAndValidateInput(input: String): Boolean {
        if (input.toCharArray().isEmpty()) {
            return false
        } else if (input == "exit") {
            exitProcess(0)
        }
        return true
    }

    companion object {

        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            Executor().launch()
        }

    }
}

fun main() {
    Executor().launch()
}