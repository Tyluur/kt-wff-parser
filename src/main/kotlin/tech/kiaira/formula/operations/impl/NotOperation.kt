package tech.kiaira.formula.operations.impl

import tech.kiaira.formula.WFFData
import tech.kiaira.formula.operations.FormulaOperation

/**
 * @author Tyluur <contact@kiaira.tech>
 * @since 2020-01-02
 */
class NotOperation(contents: String,
                   firstOperand: String) : FormulaOperation(contents, WFFData.NOT, "Operation ${WFFData.NOT} on $firstOperand", firstOperand, null) {
}