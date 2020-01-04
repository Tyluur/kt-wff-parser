package tech.kiaira.formula.operations.impl

import tech.kiaira.formula.operations.FormulaOperation

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2020-01-02
 */
class VariableOperation(contents: String,
                        firstOperand: String) : FormulaOperation(contents, null, "Initialization of $firstOperand", firstOperand, null) {

}