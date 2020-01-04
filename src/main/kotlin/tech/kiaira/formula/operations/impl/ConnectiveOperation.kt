package tech.kiaira.formula.operations.impl

import tech.kiaira.formula.operations.FormulaOperation

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2020-01-02
 */
class ConnectiveOperation(contents: String,
                          operator: Char?,
                          firstOperand: String,
                          secondOperand: String?) : FormulaOperation(contents, operator, "Operation $operator on $firstOperand $secondOperand", firstOperand, secondOperand) {

}