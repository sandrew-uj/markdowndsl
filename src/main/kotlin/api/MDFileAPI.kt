package api

interface MDElement

class MDFile() {
    val elements = ArrayList<MDElement>()

    fun convertToText(): String = StringBuilder().apply {
        elements.forEach { append(it.toString()) }
    }.toString().trimIndent()
}