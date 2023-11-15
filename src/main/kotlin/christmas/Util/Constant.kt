package christmas.Util

class Constant {
    companion object {

        // 예외 메세지 출력
        // 1 이상 31 이하의 숫자가 아닌 경우
        const val INPUT_NOT_VISIT_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
        // 고객이 메뉴판에 없는 메뉴를 입력하는 경우
        const val INPUT_ENTER_WITHOUT_MENU =  "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        // 메뉴의 개수 입력할 때 1 이상의 숫자가 아닐 경우
        const val INPUT_OTHER_THAN_ONE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        // 메뉴 형식이 예시와 다른 경우
        const val INPUT_DIFFERENT_FORM_THE_EXAMPLE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        // 중복 메뉴를 입력한 경우
        const val INPUT_SAME_MENU = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
        // 메뉴가 20개 이상일 때
        const val INPUT_MENU_INPUT_MORE_THAN_20 = "[ERROR] 메뉴 개수 입력은 20개를 넘을 수 없습니다. 다시 입력해주세요."
        const val DATE_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
        const val INPUT_IS_NUMBER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."

        // 출력 메세지
        const val OUTPUT_INTRODUCE_EVENT_PLANNER = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        const val OUTPUT_EXPECT_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        const val INPUT_TAKE_ORDER_MENU_AND_NUMBER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
        const val PREVIEW_EVENT_BENEFITS = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
        const val OUTPUT_ORDERED_MENU = "<주문 메뉴>"
        const val OUTPUT_TOTAL_ORDER_AMOUT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>"
        const val OUTPUT_PRESENTATION_MENU = "<증정 메뉴>"
        const val OUTPUT_BENEFITS_DETAIL = "<혜택 내역>"
        const val OUTPUT_TOTAL_BENEFITS_AMOUNT = "<총혜택 금액>"
        const val OUTPUT_ESTIMATED_PAYMENT_AMOUNT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>"
        const val OUTPUT_EVENT_BADGE = "<12월 이벤트 배지>"
        const val OUTPUT_CHRISTMAS_DDAY_DISCOUNT = "크리스마스 디데이 할인 :"
        const val OUTPUT_WEEKDAY_DISCOUNT = "평일 할인 :"
        const val OUTPUT_WEEKEND_DISCOUNT = "주말 할인 :"
        const val OUTPUT_SPECIAL_DISCOUNT = "특별 할인 :"
        const val OUTPUT_PRESENTATION_EVENT = "증정 이벤트 :"
        const val OUTPUT_NO_GIFT_EVENT = "없음"
        const val OUTPUT_STARS_BADGE = "스타"
        const val OUTPUT_TREES_BADGE = "트리"
        const val OUTPUT_SANTAS_BADGE = "산타"


        // 메뉴 이름
        const val PINE_MUSHROOM_SOUP = "양송이수프"
        const val TAPAS = "타파스"
        const val CAESAR_SALAD = "시저샐러드"
        const val T_BONE_STEAK = "티본스테이크"
        const val BBQ_RIBS = "바비큐립"
        const val SEAFOOD_PASTA = "해산물파스타"
        const val CHRISTMAS_PASTA = "크리스마스파스타"
        const val CHOCOLATE_CAKE = "초코케이크"
        const val ICE_CREAM = "아이스크림"
        const val ZERO_COKE = "제로콜라"
        const val RED_WINE = "레드와인"
        const val CHAMPAGNE = "샴페인"

        // 메뉴 가격
        const val PINE_MUSHROOM_SOUP_PRICE = 6_000
        const val TAPAS_PRICE = 5_500
        const val CAESAR_SALAD_PRICE = 8_000
        const val T_BONE_STEAK_PRICE = 55_000
        const val BBQ_RIBS_PRICE = 54_000
        const val SEAFOOD_PASTA_PRICE = 35_000
        const val CHRISTMAS_PASTA_PRICE = 25_000
        const val CHOCOLATE_CAKE_PRICE = 15_000
        const val ICE_CREAM_PRICE = 5_000
        const val ZERO_COKE_PRICE = 3_000
        const val RED_WINE_PRICE = 60_000
        const val CHAMPAGNE_PRICE = 25_000
        const val PRESENTATION_EVENT_PRICE = 120_000

    }

}