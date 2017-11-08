package com.hannesdorfmann.ui

import com.hannesdorfmann.observable.Observable
import com.hannesdorfmann.observable.Observer
import com.sun.tools.javac.util.FatalError
import javafx.scene.Parent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import tornadofx.View
import tornadofx.button
import tornadofx.row

class ButtonView() : View() {

    override val root = GridPane()

    init {
        with(root) {

            row {
                button("Click me") {
                    isDefaultButton = true
                }.also { button ->

                    Observable.create<String> { observer ->
                        button.setOnAction {
                            observer.onNext("clicked!")
                            throw Exception("Foo")
                        }
                    }.take(2)
                            .map { txt -> txt.toUpperCase() }
                            .subscribe(object : Observer<String> {
                                override fun onNext(item: String?) {

                                    println(item)
                                }

                                override fun onError(error: Throwable) {
                                    println("onError")
                                    error.printStackTrace()
                                }

                                override fun onComplete() {
                                    println("onComplete")
                                }
                            })


                }


            }
        }
    }
}