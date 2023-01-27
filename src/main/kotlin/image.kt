@ContextDsl
fun MDFile.image(link: String = "", builder: MDElement.() -> String) {
    elements.add(
        object : MDElement {
            val content = builder.invoke(this)
            override fun toString(): String = "![$content]($link)"
        }
    )
}