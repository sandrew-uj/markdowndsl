@ContextDsl
fun MDFile.link(link: String = "", builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "[$content]($link)"
        }
    )
}