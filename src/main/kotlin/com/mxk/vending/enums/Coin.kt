package com.mxk.vending.enums

/*
 * Coin in pence to prevent Double/Float currency issues
 */
enum class Coin(pence: Int) {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    POUND(100);

    var pence = pence
}