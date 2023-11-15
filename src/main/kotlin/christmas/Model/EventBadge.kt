package christmas.Model

import christmas.Util.Constant.Companion.OUTPUT_NO_GIFT_EVENT
import christmas.Util.Constant.Companion.OUTPUT_SANTAS_BADGE
import christmas.Util.Constant.Companion.OUTPUT_STARS_BADGE
import christmas.Util.Constant.Companion.OUTPUT_TREES_BADGE
import java.time.LocalDate

class EventBadge(private val date: LocalDate) { // 이벤트 배지 종류 및 증정 방법 클래스.
    val calculate = CalculatePrice(date)
    fun getBadges(orders: MutableList<Pair<String, Int>>): String {
        val totalDiscount = calculate.calculateTotalDiscountPrice(orders)
        return when {
            totalDiscount >= 20000 -> OUTPUT_SANTAS_BADGE
            totalDiscount >= 10000 -> OUTPUT_TREES_BADGE
            totalDiscount >= 5000 -> OUTPUT_STARS_BADGE
            else -> OUTPUT_NO_GIFT_EVENT
        }
    }
}