import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TestMarkdown {

    @Test
    fun `Test text`() {
        assertEquals(
            "Hello" + "World!",
            mdfile {
                t { "Hello" }
                t { "World!" }
            }.convertToText()
        )
    }

    @Test
    fun `Test Italic element`() {
        assertEquals(
            "*im italic*",
            mdfile {
                i { "im italic" }
            }.convertToText()
        )
    }

    @Test
    fun `Test Bold element`() {
        assertEquals(
            "**im bold**",
            mdfile {
                b { "im bold" }
            }.convertToText()
        )
    }

    @Test
    fun `Test Headers`() {
        assertEquals(
            "# header1",
            mdfile {
                h1 { "header1" }
            }.convertToText()
        )
        assertEquals(
            "## header2",
            mdfile {
                h2 { "header2" }
            }.convertToText()
        )
        assertEquals(
            "### header3",
            mdfile {
                h3 { "header3" }
            }.convertToText()
        )
    }

    @Test
    fun `Test Code`() {
        assertEquals(
            "`println(Hello World!)`",
            mdfile {
                code { "println(Hello World!)" }
            }.convertToText()
        )
    }

    @Test
    fun `Test CodeBlock`() {
        assertEquals(
            """
                ```c++
                cout << "Hello World!";
                ```
            """.trimIndent(),
            mdfile {
                codeBlock("c++") { "cout << \"Hello World!\";" }
            }.convertToText()
        )
    }

    @Test
    fun `Test Rule`() {
        assertEquals(
            "---".trimIndent(),
            mdfile {
                hr()
            }.convertToText()
        )
    }

    @Test
    fun `Test Image`() {
        assertEquals(
            "![i love capys](capybara.jpg)".trimIndent(),
            mdfile {
                image("capybara.jpg") {
                    "i love capys"
                }
            }.convertToText()
        )
    }

    @Test
    fun `Test Link`() {
        assertEquals(
            "[some text](https://www.test.com)".trimIndent(),
            mdfile {
                link("https://www.test.com") {
                    "some text"
                }
            }.convertToText()
        )
    }

    @Test
    fun `Test Table`() {
        assertEquals(
            """
                | a | b |
                | ----------- | ----------- |
                | c | d |
                | e | f |
            """.trimIndent(),
            mdfile {
                table {
                    th { item { "a" }; item { "b" } }
                    tr { item { "c" }; item { "d" } }
                    tr { item { "e" }; item { "f" } }
                }
            }.convertToText()
        )
    }

    @Test
    fun `Test Unordered List`() {
        assertEquals(
            """
                - first
                - second
            """.trimIndent(),
            mdfile {
                ul {
                    item { "first" }
                    item { "second" }
                }
            }.convertToText()
        )
    }

    @Test
    fun `Test Ordered`() {
        assertEquals(
            """
                1. first
                2. second
            """.trimIndent(),
            mdfile {
                ol {
                    item { "first" }
                    item { "second" }
                }
            }.convertToText()
        )
    }

    @Test
    fun `Test Check List`() {
        assertEquals(
            """
                - [x] im ok
                - [ ] im not ok
            """.trimIndent(),
            mdfile {
                cl {
                    item(true) { "im ok" }
                    item(false) { "im not ok" }
                }
            }.convertToText()
        )
    }

}