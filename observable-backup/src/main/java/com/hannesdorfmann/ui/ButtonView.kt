package com.hannesdorfmann.ui

import javafx.scene.layout.GridPane
import tornadofx.button
import tornadofx.row

class ButtonView() : tornadofx.View() {

    override val root = GridPane()

    init {
        with(root) {

            row {
                button ("Click me") {
                    isDefaultButton = true
                }.also { button ->
                    button.setOnAction {
                       println("clicked!")
                    }

                }
            }
        }
    }
}