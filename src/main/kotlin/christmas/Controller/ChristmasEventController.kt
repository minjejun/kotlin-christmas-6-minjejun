package christmas.Controller

import christmas.Model.CalculatePrice
import christmas.Model.EventBadge
import christmas.Model.EventDiscountType
import christmas.View.InputView
import christmas.View.OutputView

class ChristmasEventController(
    private val outputView: OutputView,
    private val inputView: InputView,
) {
    fun start() {
        // 이벤트 날짜 입력 받음
        val date = inputView.readDate()

        // 이벤트 혜택 미리보기 출력
        outputView.printPreviewEventBenefits(date)

        // 사용자로부터 주문 메뉴와 수량 입력 받음
        val orders = inputView.readOrderMenusandNumber()

        // EventDiscountType 인스턴스 생성. 특정 날짜에 따른 이벤트 할인 유형을 결정
        val eventDiscountType = EventDiscountType(date)
        // CalculatePrice 인스턴스 생성. 주문에 대한 총 가격, 할인 가격 등을 계산하는 데 사용
        val calculatePrice = CalculatePrice(date)
        // EventBadge 인스턴스 생성. 주문에 따른 이벤트 뱃지를 결정하는 데 사용
        val eventBadge = EventBadge(date)

        // 할인 적용 전 총 가격 계산
        val totalPrice = calculatePrice.calculateTotalPrice(orders)

        // 크리스마스 증정 이벤트 메뉴 계산
        val presentationMenu: Pair<String, Int>? = eventDiscountType.ChristmasPresentationEvent(orders)

        // 총 혜택 가격 계산
        val totalBenefitsAmount = calculatePrice.calculateTotalDiscountPrice(orders)

        // 할인 적용 후 예상 금액 계산
        val estimatedPrice = calculatePrice.calculateExpectPriceAfterDiscount(orders)

        // 이벤트 뱃지 계산
        val badge = eventBadge.getBadges(orders)

        outputView.printOrderedMenu(orders) // 주문 메뉴 출력
        outputView.printAmountPriceBeforeDiscount(totalPrice) // 할인 적용 전 총 가격 출력
        outputView.printPresentationMenu(presentationMenu) // 크리스마스 증정 이벤트 메뉴 출력
        outputView.printBenefitsDetails(orders, presentationMenu, date) // 혜택 내역 출력
        outputView.printTotalBenefitsAmounts(totalBenefitsAmount) // 총 혜택 가격 출력
        outputView.printEstimatedPriceAfterDiscount(estimatedPrice) // 할인 적용 후 예상 금액 출력
        outputView.printChristmasEventBadge(badge) // 이벤트 뱃지 출력
    }
}