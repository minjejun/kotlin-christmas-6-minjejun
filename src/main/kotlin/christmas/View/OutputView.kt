package christmas.View

import christmas.Model.CalculatePrice
import christmas.Model.MenuandPriceList
import christmas.Util.Constant.Companion.INPUT_TAKE_ORDER_MENU_AND_NUMBER
import christmas.Util.Constant.Companion.OUTPUT_BENEFITS_DETAIL
import christmas.Util.Constant.Companion.OUTPUT_CHRISTMAS_DDAY_DISCOUNT
import christmas.Util.Constant.Companion.OUTPUT_ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT
import christmas.Util.Constant.Companion.OUTPUT_EVENT_BADGE
import christmas.Util.Constant.Companion.OUTPUT_EXPECT_VISIT_DATE
import christmas.Util.Constant.Companion.OUTPUT_INTRODUCE_EVENT_PLANNER
import christmas.Util.Constant.Companion.OUTPUT_NO_GIFT_EVENT
import christmas.Util.Constant.Companion.OUTPUT_ORDERED_MENU
import christmas.Util.Constant.Companion.OUTPUT_PRESENTATION_EVENT
import christmas.Util.Constant.Companion.OUTPUT_PRESENTATION_MENU
import christmas.Util.Constant.Companion.OUTPUT_SPECIAL_DISCOUNT
import christmas.Util.Constant.Companion.OUTPUT_TOTAL_BENEFITS_AMOUNT
import christmas.Util.Constant.Companion.OUTPUT_TOTAL_ORDER_AMOUT_BEFORE_DISCOUNT
import christmas.Util.Constant.Companion.OUTPUT_WEEKDAY_DISCOUNT
import christmas.Util.Constant.Companion.OUTPUT_WEEKEND_DISCOUNT
import christmas.Util.Constant.Companion.PREVIEW_EVENT_BENEFITS
import java.time.LocalDate


class OutputView {

    fun printPreviewEventBenefits(date: LocalDate) { // 받을 혜택 미리보기 출력
        println(PREVIEW_EVENT_BENEFITS.format(date.dayOfMonth))
    }

    fun printOrderedMenu(orders: List<Pair<String, Int>>) { // 주문 메뉴 출력
        println(OUTPUT_ORDERED_MENU)
        orders.forEach { (menu, count) ->
            println("${menu} ${count}개")
        }
    }

    fun printAmountPriceBeforeDiscount(totalPrice: Int) { // 할인 전 총 주문 금액 출력
        println(OUTPUT_TOTAL_ORDER_AMOUT_BEFORE_DISCOUNT)
        println("${totalPrice}원")
    }

    fun printPresentationMenu(presentationMenu: Pair<String, Int>?) { // 증정 메뉴 출력
        println(OUTPUT_PRESENTATION_MENU)
        if (presentationMenu != null) {
            println("${presentationMenu.first} 1개")
        } else {
            println(OUTPUT_NO_GIFT_EVENT)
        }
    }

    fun printBenefitsDetails( // 혜택 내역 출력
        orders: MutableList<Pair<String, Int>>,
        presentationMenu: Pair<String, Int>?,
        date: LocalDate,
    ) {
        val calculatePrice = CalculatePrice(date)  // CalculatePrice 인스턴스 생성
        val benefits = calculatePrice.calculateBenefit(orders)  // 혜택 계산

        println(OUTPUT_BENEFITS_DETAIL) // <혜택 내역>

        if (date.dayOfMonth > 25) {
            println(OUTPUT_NO_GIFT_EVENT)
        } else {
            benefits.forEach { benefit, value ->
                when (benefit) {
                    OUTPUT_CHRISTMAS_DDAY_DISCOUNT,
                    OUTPUT_WEEKDAY_DISCOUNT,
                    OUTPUT_WEEKEND_DISCOUNT,
                    OUTPUT_SPECIAL_DISCOUNT -> if (value > 0) println("${benefit} -${value}원")

                    OUTPUT_PRESENTATION_EVENT -> {
                        if (value != 0) println("${benefit} ${MenuandPriceList.DRINK_3.foodMenu} 1개 -${value}원")
                        else println(OUTPUT_NO_GIFT_EVENT)

                        if (presentationMenu?.first?.isNotEmpty() == true) {
                            println("${OUTPUT_PRESENTATION_EVENT} ${presentationMenu.first} 1개 -${presentationMenu.second}원")
                        } else {
                            println(OUTPUT_NO_GIFT_EVENT)
                        }
                    }
                }
            }
        }
    }

    fun printTotalBenefitsAmounts(totalBenefitsAmount: Int) { // 총 혜택 금액 출력
        println(OUTPUT_TOTAL_BENEFITS_AMOUNT)
        println("-${totalBenefitsAmount}원")
        // 혜택 내역들을 전부 add.
    }

    fun printEstimatedPriceAfterDiscount(estimatedPrice: Int) { // 할인 후 예상 결제 금액 출력.
        println(OUTPUT_ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT)
        println("${estimatedPrice}원")
        // 할인 전 총 주문 금액 - 할인 금액
    }

    fun printChristmasEventBadge(badge: String) { // 이벤트 뱃지 내용 출력.
        println(OUTPUT_EVENT_BADGE)
        println(badge)
    }
}