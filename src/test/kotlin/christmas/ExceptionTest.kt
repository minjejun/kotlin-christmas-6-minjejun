package christmas

import christmas.Util.Constant.Companion.INPUT_DIFFERENT_FORM_THE_EXAMPLE
import christmas.Util.Constant.Companion.INPUT_ENTER_WITHOUT_MENU
import christmas.Util.Constant.Companion.INPUT_MENU_INPUT_MORE_THAN_20
import christmas.Util.Constant.Companion.INPUT_OTHER_THAN_ONE
import christmas.Util.Constant.Companion.INPUT_SAME_MENU
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy
import christmas.Util.Exception

class ExceptionTest {

    @Test
    fun `checkOrderInputException should throw exception when menu does not exist`() {
        assertThatThrownBy { Exception.checkOrderInputException("non_existing_menu") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_ENTER_WITHOUT_MENU)
    }

    @Test
    fun `checkOrderDuplicateException should throw exception when order is duplicated`() {
        val orders = listOf(Pair("menu1", 1), Pair("menu2", 2))
        assertThatThrownBy { Exception.checkOrderDuplicateException("menu1", orders) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_SAME_MENU)
    }

    @Test
    fun `checkOrderNumberException should throw exception when order number is less than 1`() {
        assertThatThrownBy { Exception.checkOrderNumberException(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_OTHER_THAN_ONE)
    }

    @Test
    fun `checkOrderNumberException should throw exception when order number is more than 20`() {
        assertThatThrownBy { Exception.checkOrderNumberException(21) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_MENU_INPUT_MORE_THAN_20)
    }

    @Test
    fun `checkOrderTypeException should throw exception when order type is incorrect`() {
        assertThatThrownBy { Exception.checkOrderTypeException("wrong-order-type") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INPUT_DIFFERENT_FORM_THE_EXAMPLE)
    }
}