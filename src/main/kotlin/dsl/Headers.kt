package dsl

import api.*

class HeaderItem : MDElement {
    lateinit var content: String
    override fun toString(): String = content
}

class Header(val level: String) : MDElement {
    lateinit var item: HeaderItem
    override fun toString(): String = "$level $item"
}

@ContextDsl
fun MDFile.h1(builder: Header.() -> Unit) = elements.add(Header("#").apply(builder))

@ContextDsl
fun MDFile.h2(builder: Header.() -> Unit) = elements.add(Header("##").apply(builder))

@ContextDsl
fun MDFile.h3(builder: Header.() -> Unit) = elements.add(Header("###").apply(builder))


@ContextDsl
fun Header.i(builder: HeaderItem.() -> String) { item = HeaderItem().apply { content = "*${builder.invoke(this)}*" }}

@ContextDsl
fun Header.b(builder: HeaderItem.() -> String) { item = HeaderItem().apply { content = "**${builder.invoke(this)}**" }}

@ContextDsl
fun Header.t(builder: HeaderItem.() -> String) { item = HeaderItem().apply { content = builder.invoke(this) }}