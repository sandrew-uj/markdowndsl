package api

class ListItem : MDElement {
    lateinit var content: String
    override fun toString(): String = content
}

class CheckedItem(val isChecked: Boolean) : MDElement {
    lateinit var content: String
    override fun toString(): String = content
}

interface MDList : MDElement

class OrderedList : MDList {
    val items = ArrayList<ListItem>()
    override fun toString(): String = items.mapIndexed { i, v -> "${i + 1}. $v" }.joinToString("\n") + "\n"
}

class UnorderedList : MDList {
    val items = ArrayList<ListItem>()
    override fun toString(): String = items.joinToString("\n") { v -> "- $v" } + "\n"
}

class CheckList : MDList {
    val items = ArrayList<CheckedItem>()
    override fun toString(): String =
        items.joinToString("\n") { v -> "- [${if (v.isChecked) "x" else " "}] $v" } + "\n"
}