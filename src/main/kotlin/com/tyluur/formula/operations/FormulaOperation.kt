package com.tyluur.formula.operations

/**
 * This class denotes a formula operation
 * @constructor
 */
abstract class FormulaOperation(private val contents: String,
                                private val operator: Char?,
                                private val explanation: String,
                                val firstOperand: String,
                                private val secondOperand: String?) {

    override fun toString(): String {
        return "$contents | [$explanation]"
    }
}