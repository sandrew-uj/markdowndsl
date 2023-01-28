package dsl

import api.*

@ContextDsl
fun MDFile.h1(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "# $content"
        }
    )
}

@ContextDsl
fun MDFile.h2(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "## $content"
        }
    )
}

@ContextDsl
fun MDFile.h3(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "### $content"
        }
    )
}