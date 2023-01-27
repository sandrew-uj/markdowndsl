@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class ContextDsl

interface MDElement {
    override fun toString(): String
}


class MDFile {
    val elements = ArrayList<MDElement>()

    fun convertToText(): String = StringBuilder().apply {
        elements.forEach { append(it.toString()) }
    }.toString().trimIndent()
}

@ContextDsl
fun mdfile(builder: MDFile.() -> Unit) = MDFile().apply(builder)

