package dsl

import api.*

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

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun Table.code(builder: MDElement.() -> String) {}

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun Table.h1(builder: MDElement.() -> String) {}

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun Table.h2(builder: MDElement.() -> String) {}

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun Table.h3(builder: MDElement.() -> String) {}
