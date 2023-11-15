package christmas.Util

import christmas.Model.MenuandPriceList
import christmas.Util.Constant.Companion.DATE_INPUT_ERROR_MESSAGE
import christmas.Util.Constant.Companion.INPUT_DIFFERENT_FORM_THE_EXAMPLE
import christmas.Util.Constant.Companion.INPUT_ENTER_WITHOUT_MENU
import christmas.Util.Constant.Companion.INPUT_MENU_INPUT_MORE_THAN_20
import christmas.Util.Constant.Companion.INPUT_OTHER_THAN_ONE
import christmas.Util.Constant.Companion.INPUT_SAME_MENU

object Exception {

    // 1 이상 31 이하의 숫자가 아닌 경우
    fun checkNumberRangeException(input: Int): Int {
        return runCatching {
            require(input in 1..31)
            input
        }.recoverCatching { e ->
            when (e) {
                is IllegalArgumentException -> throw IllegalArgumentException(DATE_INPUT_ERROR_MESSAGE)
                else -> throw e
            }
        }.getOrDefault(0)
    }

    // 고객이 메뉴판에 없는 메뉴를 입력하는 경우
    fun checkOrderInputException(menu: String) {
        if (menu !in MenuandPriceList.values().map { it.foodMenu}) {
            throw IllegalArgumentException(INPUT_ENTER_WITHOUT_MENU)
        }
    }

    // 중복 메뉴를 입력한 경우
    fun checkOrderDuplicateException(menu: String, orders: List<Pair<String, Int>>) {
        if (orders.any { it.first == menu }) {
            throw IllegalArgumentException(INPUT_SAME_MENU)
        }
    }

    // 주문하는 갯수의 범위를 벗어난 경우
    fun checkOrderNumberException(count: Int) {
        // 1보다 작을 때
        if (count < 1) {
            throw IllegalArgumentException(INPUT_OTHER_THAN_ONE)
        }
        // 20개보다 많을 때
        if ( count > 20 ) {
            throw IllegalArgumentException(INPUT_MENU_INPUT_MORE_THAN_20)
        }
    }

    // 주문 형식이 메뉴 형식과 다른 경우
    fun checkOrderTypeException(order: String) {
        if (!order.contains("-") || order.split("-").size != 2) {
            throw IllegalArgumentException(INPUT_DIFFERENT_FORM_THE_EXAMPLE)
        }
    }
}