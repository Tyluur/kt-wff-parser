package com.tyluur.formula.operations.impl

import com.tyluur.formula.WFFData
import com.tyluur.formula.operations.FormulaOperation

/**
 * @author Tyluur <contact@tyluur.com>
 * @since 2020-01-02
 */
class NotOperation(contents: String,
                   firstOperand: String) : FormulaOperation(contents, WFFData.NOT, "Operation ${WFFData.NOT} on $firstOperand", firstOperand, null) {
}