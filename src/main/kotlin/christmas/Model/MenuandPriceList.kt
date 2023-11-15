package christmas.Model

import christmas.Util.Constant.Companion.BBQ_RIBS
import christmas.Util.Constant.Companion.BBQ_RIBS_PRICE
import christmas.Util.Constant.Companion.CAESAR_SALAD
import christmas.Util.Constant.Companion.CAESAR_SALAD_PRICE
import christmas.Util.Constant.Companion.CHAMPAGNE
import christmas.Util.Constant.Companion.CHAMPAGNE_PRICE
import christmas.Util.Constant.Companion.CHOCOLATE_CAKE
import christmas.Util.Constant.Companion.CHOCOLATE_CAKE_PRICE
import christmas.Util.Constant.Companion.CHRISTMAS_PASTA
import christmas.Util.Constant.Companion.CHRISTMAS_PASTA_PRICE
import christmas.Util.Constant.Companion.ICE_CREAM
import christmas.Util.Constant.Companion.ICE_CREAM_PRICE
import christmas.Util.Constant.Companion.PINE_MUSHROOM_SOUP
import christmas.Util.Constant.Companion.PINE_MUSHROOM_SOUP_PRICE
import christmas.Util.Constant.Companion.RED_WINE
import christmas.Util.Constant.Companion.RED_WINE_PRICE
import christmas.Util.Constant.Companion.SEAFOOD_PASTA
import christmas.Util.Constant.Companion.SEAFOOD_PASTA_PRICE
import christmas.Util.Constant.Companion.TAPAS
import christmas.Util.Constant.Companion.TAPAS_PRICE
import christmas.Util.Constant.Companion.T_BONE_STEAK
import christmas.Util.Constant.Companion.T_BONE_STEAK_PRICE
import christmas.Util.Constant.Companion.ZERO_COKE
import christmas.Util.Constant.Companion.ZERO_COKE_PRICE

enum class MenuandPriceList(val foodMenu: String, val price: Int) { // 음식 메뉴들, 메뉴들 가격
    // 애피타이저
    APPETIZER_1(PINE_MUSHROOM_SOUP, PINE_MUSHROOM_SOUP_PRICE),
    APPETIZER_2(TAPAS, TAPAS_PRICE),
    APPETIZER_3(CAESAR_SALAD, CAESAR_SALAD_PRICE),

    // 메인
    MAIN_1(T_BONE_STEAK, T_BONE_STEAK_PRICE),
    MAIN_2(BBQ_RIBS, BBQ_RIBS_PRICE),
    MAIN_3(SEAFOOD_PASTA, SEAFOOD_PASTA_PRICE),
    MAIN_4(CHRISTMAS_PASTA, CHRISTMAS_PASTA_PRICE),

    // 디저트
    DESSERT_1(CHOCOLATE_CAKE, CHOCOLATE_CAKE_PRICE),
    DESSERT_2(ICE_CREAM, ICE_CREAM_PRICE),

    // 음료
    DRINK_1(ZERO_COKE, ZERO_COKE_PRICE),
    DRINK_2(RED_WINE, RED_WINE_PRICE),
    DRINK_3(CHAMPAGNE, CHAMPAGNE_PRICE);
}