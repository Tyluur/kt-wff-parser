package com.tyluur.formula.operations.impl

import com.tyluur.formula.operations.FormulaOperation

/**
 * @author Tyluur <itstyluur@icloud.com>
 * @since 2020-01-02
 */
class ConnectiveOperation(contents: String,
                          operator: Char?,
                          firstOperand: String,
                          secondOperand: String?) : FormulaOperation(contents, operator, "Operation $operator on $firstOperand $secondOperand", firstOperand, secondOperand) {

}