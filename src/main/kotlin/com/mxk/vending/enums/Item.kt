package com.mxk.vending.enums

enum class Item constructor(var code: Int, var itemName: String, var cost: Int) {
    PEPSI(1, "Pepsi", 100),
    MARS(2, "Mars", 55);

}
