class ListItem : MDElement {
    lateinit var content: String
    override fun toString(): String = content
}

class CheckedItem(val isChecked: Boolean) : MDElement {
    lateinit var content: String
    override fun toString(): String = content
}

class OrderedList : MDElement {
    val items = ArrayList<ListItem>()
    override fun toString(): String = items.mapIndexed { i, v -> "${i + 1}. $v" }.joinToString("\n") + "\n"
}

class UnorderedList : MDElement {
    val items = ArrayList<ListItem>()
    override fun toString(): String = items.map { v -> "- $v" }.joinToString("\n") + "\n"
}

class CheckList : MDElement {
    val items = ArrayList<CheckedItem>()
    override fun toString(): String =
        items.map { v -> "- [${if (v.isChecked) "x" else " "}] $v" }.joinToString("\n") + "\n"
}


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