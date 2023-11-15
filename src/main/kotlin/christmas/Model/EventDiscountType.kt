package christmas.Model

import christmas.Util.Constant.Companion.OUTPUT_NO_GIFT_EVENT
import christmas.Util.Constant.Companion.PRESENTATION_EVENT_PRICE
import christmas.View.InputView
import java.time.DayOfWeek
import java.time.LocalDate

@Suppress("UNREACHABLE_CODE")
class EventDiscountType(private val date: LocalDate) { // 이벤트 할인 종류 구분하는 클래스.
    val dayOfWeek = date.dayOfWeek
    // 크리스마스 디데이 할인
    // 이벤트 기간: 2023.12.1 ~ 2023.12.25
    // 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
    // 총 주문 금액에서 해당 금액만큼 할인
    // (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
    fun ChristmasDdayDiscount(): Int {
        if(date.dayOfMonth in 1..25) {
            val baseDiscount= 1000
            val additionalDiscountPerDay = 100
            val daysFromStart = date.dayOfMonth - 1 // 12월 1일을 시작일로 하였으므로 1을 빼줘서 원래 날짜에서 1을 빼줌.

            return baseDiscount + (additionalDiscountPerDay * daysFromStart)
        } else {
            return 0
        }
    }


    // 평일 할인(일요일~목요일 = 금요일, 토요일 뺀 나머지 요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
    fun ChristmasWeekdayDiscount(orders: List<Pair<String, Int>>): Int {
        val dessertCount = orders.count { order ->
            order.first in listOf(MenuandPriceList.DESSERT_1.foodMenu, MenuandPriceList.DESSERT_2.foodMenu)
        }
        return when (dayOfWeek) {
            DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, -> {
                dessertCount * 2023
            }
            else -> {
                0
            }

        }
    }

    // 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
    fun ChristmasWeekendDiscount(orders: List<Pair<String, Int>>): Int {
        val mainmenuCount = orders.count { order ->
            order.first in listOf(MenuandPriceList.MAIN_1.foodMenu, MenuandPriceList.MAIN_2.foodMenu, MenuandPriceList.MAIN_3.foodMenu, MenuandPriceList.MAIN_4.foodMenu)
        }
        return when (dayOfWeek) {
            DayOfWeek.FRIDAY, DayOfWeek.SATURDAY -> {
                mainmenuCount * 2023
            }
            else -> {
                0
            }
        }
    }

    // 특별 할인: 이벤트 달력에 별이 있으면 총 주문 금액에서 1,000원 할인
    fun ChristmasaSpecialDiscount(): Int {
        return when {
            date.dayOfWeek == DayOfWeek.SUNDAY && date.dayOfMonth == 25 -> {
                1000
            }
            else -> {
                0
            }
        }
    }

    // 증정 이벤트 : 할인 전 총 금액이 12만원 이상일 때, 샴페인 1개 증정.=
    fun ChristmasPresentationEvent(orders: MutableList<Pair<String, Int>>): Pair<String, Int>? {
        val calculate = CalculatePrice(date)
        val totalPrice = calculate.calculateTotalPrice(orders)
        return if(totalPrice>= PRESENTATION_EVENT_PRICE){
            MenuandPriceList.DRINK_3.foodMenu to MenuandPriceList.DRINK_3.price
        } else {
            null
        }
    }

}