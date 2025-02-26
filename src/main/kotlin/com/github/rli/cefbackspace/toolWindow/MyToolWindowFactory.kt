package com.github.rli.cefbackspace.toolWindow

import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.jcef.JBCefBrowser


class MyToolWindowFactory : ToolWindowFactory {

    init {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val browser = JBCefBrowser.createBuilder().build()
        toolWindow.contentManager.addContent(
            toolWindow.contentManager.factory.createContent(
                browser.component,
                "JCEF",
                false
            )
        )

        browser.loadHTML(
            // language=HTML
            """
                <html>
                    <body>
                        <input type="text" id="input" />
                    </body>
                </html>
            """.trimIndent()
        )
    }

    override fun shouldBeAvailable(project: Project) = true
}
