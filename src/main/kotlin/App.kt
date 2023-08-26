import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import java.util.function.Consumer
import javax.swing.*

class App : JFrame() {
    init {
        initUI()
    }

    private fun initUI() {
        createMenuBar()
        title = "Submenu"
        setSize(360, 250)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
    }

    private fun createMenuBar() {
        val menuBar = JMenuBar()

        val fileMenu = createFileMenu()
        menuBar.add(fileMenu)

        val viewMenu = createViewMenu()
        menuBar.add(viewMenu)

        val toolsMenu = createToolsMenu()
        menuBar.add(toolsMenu)
        menuBar.add(Box.createHorizontalGlue())

        val helpMenu = JMenu("Help")
        menuBar.add(helpMenu)
        jMenuBar = menuBar
    }

    private fun createFileMenu(): JMenu {
        val menu = JMenu("File")
        val newMenuItem = JMenuItem("New...")
        menu.add(newMenuItem)
        menu.add(JMenuItem("Custom Race Wizard..."))

        val openMenuItem = JMenuItem("Open...")
        menu.add(openMenuItem)
        menu.add(JMenuItem("Close"))

        val saveMenuItem = JMenuItem("Save")
        menu.add(saveMenuItem)
        menu.add(JMenuItem("Save And Submit"))
        menu.addSeparator()
        menu.add(JMenuItem("Print Map"))

        val exitMenuItem = JMenuItem("Exit")
        exitMenuItem.toolTipText = "Exit application"
        exitMenuItem.addActionListener { event: ActionEvent? -> System.exit(0) }
        menu.addSeparator()
        menu.add(exitMenuItem)
        return menu
    }

    private fun createViewMenu(): JMenu {
        val menu = JMenu("View")
        val showToolBarMenuItem = JCheckBoxMenuItem("Toolbar")
        showToolBarMenuItem.mnemonic = KeyEvent.VK_S
        showToolBarMenuItem.displayedMnemonicIndex = 5
        showToolBarMenuItem.isSelected = true

        menu.add(showToolBarMenuItem)
        menu.addSeparator()

        val findMenuItem = JMenuItem("Find...")
        menu.add(findMenuItem)

        val zoomMenu = JMenu("Zoom")
        val zoomGroup = ButtonGroup()

        val zoomOptions = listOf(
            JRadioButtonMenuItem("25%"),
            JRadioButtonMenuItem("38%"),
            JRadioButtonMenuItem("50%"),
            JRadioButtonMenuItem("75%"),
            JRadioButtonMenuItem("100%"),
            JRadioButtonMenuItem("125%"),
            JRadioButtonMenuItem("150%"),
            JRadioButtonMenuItem("200%"),
            JRadioButtonMenuItem("400%")
        )
        zoomOptions.forEach(Consumer<JRadioButtonMenuItem> { item: JRadioButtonMenuItem? ->
            zoomGroup.add(item)
            zoomMenu.add(item)
        })
        menu.add(zoomMenu)

        val windowLayoutMenu = JMenu("Window Layout")
        val windowLayoutGroup = ButtonGroup()

        val windowLayoutOptions = listOf(
            JRadioButtonMenuItem("Large Screen"),
            JRadioButtonMenuItem("Medium Screen"),
            JRadioButtonMenuItem("Small Screen")
        )
        windowLayoutOptions.forEach(Consumer<JRadioButtonMenuItem> { item: JRadioButtonMenuItem? ->
            windowLayoutMenu.add(item)
            windowLayoutGroup.add(item)
        })
        menu.add(windowLayoutMenu)

        val showPlayerColoursMenuItem = JCheckBoxMenuItem("Player Colours")
        showPlayerColoursMenuItem.mnemonic = KeyEvent.VK_S
        showPlayerColoursMenuItem.displayedMnemonicIndex = 7
        showPlayerColoursMenuItem.isSelected = true
        menu.add(showPlayerColoursMenuItem)
        menu.addSeparator()

        val raceMenuItem = JMenuItem("Race...")
        menu.add(raceMenuItem)

        val gameParametersMenuItem = JMenuItem("Game Parameters...")
        menu.add(gameParametersMenuItem)
        return menu
    }

    private fun createToolsMenu(): JMenu {
        return JMenu("Tools")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                val ex = App()
                ex.isVisible = true
            }
        }
    }
}
