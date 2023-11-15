package christmas

import christmas.Controller.ChristmasEventController
import christmas.View.InputView
import christmas.View.OutputView


fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    ChristmasEventController(
        inputView = inputView,
        outputView = outputView,
    ).start()
}
