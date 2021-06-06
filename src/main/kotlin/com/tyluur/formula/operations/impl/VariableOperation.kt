package com.tyluur.formula.operations.impl

import com.tyluur.formula.operations.FormulaOperation

/**
 * @author Tyluur <contact@tyluur.com>
 * @since 2020-01-02
 */
class VariableOperation(contents: String,
                        firstOperand: String) : FormulaOperation(contents, null, "Initialization of $firstOperand", firstOperand, null) {

}