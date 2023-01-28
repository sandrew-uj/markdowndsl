package dsl

import api.*

@ContextDsl
fun TableRow.item(builder: TableRow.() -> String) = cols.add(builder.invoke(this))

@ContextDsl
fun OrderedList.item(builder: ListItem.() -> String) = items.add(ListItem().apply { content = builder.invoke(this) })

@ContextDsl
fun UnorderedList.item(builder: ListItem.() -> String) = items.add(ListItem().apply { content = builder.invoke(this) })

@ContextDsl
fun CheckList.item(isChecked: Boolean = false, builder: CheckedItem.() -> String) =
    items.add(CheckedItem(isChecked).apply { content = builder.invoke(this) })

@ContextDsl
fun MDFile.ol(builder: OrderedList.() -> Unit) = elements.add(OrderedList().apply(builder))

@ContextDsl
fun MDFile.ul(builder: UnorderedList.() -> Unit) = elements.add(UnorderedList().apply(builder))

@ContextDsl
fun MDFile.cl(builder: CheckList.() -> Unit) = elements.add(CheckList().apply(builder))

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun MDList.code(builder: MDElement.() -> String) {}

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun MDList.h1(builder: MDElement.() -> String) {}

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun MDList.h2(builder: MDElement.() -> String) {}

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun MDList.h3(builder: MDElement.() -> String) {}