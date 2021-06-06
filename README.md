# kotlin-wff-parser
This software parses well formed formulas, validates them, and outputs construction sequences as well as proper initial segments. To learn more about WFF, you can read about them on [SkillfulReasoning](http://www.skillfulreasoning.com/propositional_logic/well-formed_formulas.html), [Wikipedia](https://en.wikipedia.org/wiki/Well-formed_formula), or a variety of other sources by performing a [Google Search](https://lmgtfy.com/?q=well+formed+formula).

#### Well Formed Formulas
In mathematical logic, propositional logic and predicate logic, a well-formed formula, abbreviated WFF or wff, often simply formula, is a finite sequence of symbols from a given alphabet that is part of a formal language. A formal language can be identified with the set of formulas in the language.

## Program
#### Details
This program reads input from the console and performs the following operations on what is assumed to be a well-formed-formula:
1. Validate that the formula confirms to the three properties of all WFF
2. Creates the proper initial segment of the formula
3. Creates the construction sequence of the formula
 
The following symbols can be used for set operations, or you can alternatively use the input alternatives below

`NOT = '¬' `
`AND = 'Λ' `
`OR = 'ν'` 
`IMPLIES = '→'`

#### Input 
WFF Syntax is not all representable by common computer keyboards, so to represent a symbol, refer to the table below for clarification.

| Symbol        | Replacements 
| ------------- |:-------------
|¬| NOT, WEDGE
|Λ| AND, /\
|ν| OR, \/   
|→| IMPLIES, ->

You can also type 'exit' to quit the program.

##### Example

If you wish to represent a WFF such as `(a -> b)`, you would enter `(a IMPLIES b)`

# License

This project is available under the terms of the GNU license. See the LICENSE file for the copyright information and licensing terms.

# Contact

You can contact me at contact@tyluur.com

[Wikipedia]: http://www.skillfulreasoning.com/propositional_logic/well-formed_formulas.html