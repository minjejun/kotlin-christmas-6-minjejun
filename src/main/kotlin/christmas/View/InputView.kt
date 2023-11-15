package christmas.View


import camp.nextstep.edu.missionutils.Console
import christmas.Util.Constant
import christmas.Util.Constant.Companion.DATE_INPUT_ERROR_MESSAGE
import christmas.Util.Constant.Companion.INPUT_DIFFERENT_FORM_THE_EXAMPLE
import christmas.Util.Constant.Companion.INPUT_ENTER_WITHOUT_MENU
import christmas.Util.Constant.Companion.INPUT_IS_NUMBER_ERROR_MESSAGE
import christmas.Util.Constant.Companion.INPUT_MENU_INPUT_MORE_THAN_20
import christmas.Util.Constant.Companion.INPUT_NOT_VISIT_DATE
import christmas.Util.Constant.Companion.INPUT_OTHER_THAN_ONE
import christmas.Util.Constant.Companion.INPUT_TAKE_ORDER_MENU_AND_NUMBER
import christmas.Util.Constant.Companion.OUTPUT_EXPECT_VISIT_DATE
import christmas.Util.Constant.Companion.OUTPUT_INTRODUCE_EVENT_PLANNER
import christmas.Util.Exception
import java.time.LocalDate

class InputView {
    // 날짜 입력하는 함수.
    fun readDate(): LocalDate {
        println(OUTPUT_INTRODUCE_EVENT_PLANNER)
        println(OUTPUT_EXPECT_VISIT_DATE)
        while (true) {
            val input = Console.readLine().trim()
            if (isNumeric(input)) {
                val day = input.toInt()
                runCatching {
                    Exception.checkNumberRangeException(day)
                    if (day in 1..31) {
                        val year = 2023
                        val month = 12
                        return@runCatching LocalDate.of(year, month, day)
                    } else {
                        throw IllegalArgumentException(INPUT_NOT_VISIT_DATE)
                    }
                }
                    .onSuccess { return it }
                    .onFailure { println(DATE_INPUT_ERROR_MESSAGE) }
            } else {
                println(DATE_INPUT_ERROR_MESSAGE)
            }
        }
    }


    // 메뉴가 뭔지와 시키는 갯수를 적을 수 있는 함수
    fun readOrderMenusandNumber(): MutableList<Pair<String, Int>> {
        println(INPUT_TAKE_ORDER_MENU_AND_NUMBER)
        val orders = mutableListOf<Pair<String, Int>>()
        while (true) {
            val input = Console.readLine().trim()
            input.split(",").forEach { order ->
                Exception.checkOrderTypeException(order)
                val (menu, countStr) = order.split("-")
                if (countStr.all { it.isDigit() }) {
                    val count = countStr.toInt()

                    runCatching {
                        Exception.checkOrderInputException(menu)
                        Exception.checkOrderDuplicateException(menu, orders)
                        Exception.checkOrderNumberException(count)
                        Exception.checkOrderTypeException(order)
                        orders.add(menu to count)
                    }
                        .onSuccess { return@forEach }
                        .onFailure { exception ->
                            when (exception) {
                                is IllegalArgumentException -> {
                                    when (exception.message) {
                                        INPUT_ENTER_WITHOUT_MENU -> println(INPUT_ENTER_WITHOUT_MENU)
                                        INPUT_DIFFERENT_FORM_THE_EXAMPLE -> println(INPUT_DIFFERENT_FORM_THE_EXAMPLE)
                                        INPUT_OTHER_THAN_ONE -> println(INPUT_OTHER_THAN_ONE)
                                        INPUT_MENU_INPUT_MORE_THAN_20 -> println(INPUT_MENU_INPUT_MORE_THAN_20)
                                    }
                                }

                                else -> println()
                            }
                            orders.clear()
                        }
                } else {
                    println(INPUT_IS_NUMBER_ERROR_MESSAGE)
                }
            }
            return orders
        }
    }

    private fun isNumeric(input: String): Boolean = input.all { it.isDigit() }
}