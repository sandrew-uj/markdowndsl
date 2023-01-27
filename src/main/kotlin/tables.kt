class Table : MDElement {
    var headers: TableRow = TableRow()
    val rows = ArrayList<TableRow>()
    override fun toString(): String = "\n" + headers.toString() + "\n" +
            "| ----------- ".repeat(headers.cols.size) + "|" + "\n" +
            rows.map { it.toString() }.joinToString("\n") + "\n"
}

class TableRow : MDElement {
    val cols = ArrayList<String>()
    override fun toString(): String = "| " + cols.joinToString(" | ") { it } + " |"
}


@ContextDsl
fun MDFile.table(builder: Table.() -> Unit) = elements.add(Table().apply(builder))

@ContextDsl
fun Table.th(builder: TableRow.() -> Unit) {
    this.headers = TableRow().apply(builder)
}

@ContextDsl
fun Table.tr(builder: TableRow.() -> Unit) {
    this.rows.add(TableRow().apply(builder))
}
