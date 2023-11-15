package christmas.Model

import christmas.Util.Constant.Companion.OUTPUT_CHRISTMAS_DDAY_DISCOUNT
import christmas.Util.Constant.Companion.OUTPUT_PRESENTATION_EVENT
import christmas.Util.Constant.Companion.OUTPUT_SPECIAL_DISCOUNT
import christmas.Util.Constant.Companion.OUTPUT_WEEKDAY_DISCOUNT
import christmas.Util.Constant.Companion.OUTPUT_WEEKEND_DISCOUNT
import christmas.Util.Constant.Companion.PRESENTATION_EVENT_PRICE
import java.time.LocalDate

class CalculatePrice(private val date: LocalDate) { // 가격이 어떻게 되는지 계산하는 클래스.

    // 할인 전 총 금액
    fun calculateTotalPrice(orders : List<Pair<String, Int>>): Int {
        // 할인 전 총 금액은 주문을 입력받은 것들의 원래 가격들을 더하면 됨.
        var totalPrice = 0
        for (order in orders) {
            val menu = order.first
            val count = order.second
            val price = MenuandPriceList.values().first { it.foodMenu == menu }.price
            totalPrice += price * count
        }
        return totalPrice
    }

    // 혜택 내역
    fun calculateBenefit(orders: MutableList<Pair<String, Int>>): MutableMap<String, Int>{
        val discountType = EventDiscountType(date)
        val discounts = mutableMapOf<String, Int>()

        // 크리스마스 디데이 할인
        discounts[OUTPUT_CHRISTMAS_DDAY_DISCOUNT] = discountType.ChristmasDdayDiscount()

        // 평일 할인
        discounts[OUTPUT_WEEKDAY_DISCOUNT] = discountType.ChristmasWeekdayDiscount(orders)

        // 주말 할인
        discounts[OUTPUT_WEEKEND_DISCOUNT] = discountType.ChristmasWeekendDiscount(orders)

        // 특별 할인
        discounts[OUTPUT_SPECIAL_DISCOUNT] = discountType.ChristmasaSpecialDiscount()

        // 증정 이벤트
        val ordersCopy = orders.toMutableList()
        val totalPrice = calculateTotalPrice(ordersCopy)
        if (totalPrice >= PRESENTATION_EVENT_PRICE) {
            orders.add(MenuandPriceList.DRINK_3.foodMenu to 1)
            discounts[OUTPUT_PRESENTATION_EVENT] = MenuandPriceList.DRINK_3.price
        }

        return discounts
    }


    // 총 혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
    fun calculateTotalDiscountPrice(orders: MutableList<Pair<String, Int>>): Int {

        val discountType = EventDiscountType(date)
        // 할인 금액을 저장할 변수
        var totalDiscount = 0

        // 크리스마스 디데이 할인
        totalDiscount += discountType.ChristmasDdayDiscount()

        // 평일 할인
        totalDiscount += discountType.ChristmasWeekdayDiscount(orders)

        // 주말 할인
        totalDiscount += discountType.ChristmasWeekendDiscount(orders)

        // 특별 할인
        totalDiscount += discountType.ChristmasaSpecialDiscount()

        // 증정 이벤트
        val calculate = CalculatePrice(date)
        val totalPrice = calculate.calculateTotalPrice(orders)
        if ( totalPrice >= PRESENTATION_EVENT_PRICE) {
            orders.add(MenuandPriceList.DRINK_3.foodMenu to 1)
            totalDiscount += MenuandPriceList.DRINK_3.price
        }

        return totalDiscount
    }

    // 할인 후 예상 결제 금액 = 할인 전 총 주문 금액 - 할인 금액
    fun calculateExpectPriceAfterDiscount(orders: MutableList<Pair<String, Int>>): Int {
        val totalPrice = calculateTotalPrice(orders)
        val totalDiscount = calculateTotalDiscountPrice(orders)
        return totalPrice - totalDiscount
    }
}