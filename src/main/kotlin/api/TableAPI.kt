package api

class Table : MDElement {
    var headers: TableRow = TableRow()
    val rows = ArrayList<TableRow>()
    override fun toString(): String = "\n" + headers.toString() + "\n" +
            "| ----------- ".repeat(headers.cols.size) + "|" + "\n" +
            rows.joinToString("\n") { it.toString() } + "\n"
}

class TableRow : MDElement {
    val cols = ArrayList<String>()
    override fun toString(): String = "| " + cols.joinToString(" | ") { it } + " |"
}