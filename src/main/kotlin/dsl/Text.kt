package dsl

import api.*

@ContextDsl
fun MDFile.t(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder(this)
            override fun toString(): String = content
        }
    )
}

@ContextDsl
fun MDFile.i(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder(this)
            override fun toString(): String = "*$content*"
        }
    )
}

@ContextDsl
fun MDFile.b(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder(this)
            override fun toString(): String = "**$content**"
        }
    )
}
