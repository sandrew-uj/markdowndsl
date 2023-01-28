package dsl

import api.*

@ContextDsl
fun MDFile.br() {
    elements.add(
        object : MDElement {
            override fun toString(): String = "\n"
        }
    )
}

@ContextDsl
fun MDFile.hr() {
    elements.add(
        object : MDElement {
            override fun toString(): String = "---"
        }
    )
}