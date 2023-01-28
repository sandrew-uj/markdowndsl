package dsl

import api.MDFile

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class ContextDsl

@ContextDsl
fun mdfile(builder: MDFile.() -> Unit) = MDFile().apply(builder)

@Deprecated("Wrong scope", level = DeprecationLevel.ERROR)
fun MDFile.mdfile(builder: MDFile.() -> Unit) {}

