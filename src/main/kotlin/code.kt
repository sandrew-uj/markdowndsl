@ContextDsl
fun MDFile.code(builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "`$content`"
        }
    )
}


@ContextDsl
fun MDFile.codeBlock(language: String = "", builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "```$language\n$content\n```"
        }
    )
}