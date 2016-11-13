package com.mxk.vending.enums

enum class Item constructor(code: Int, itemName: String, cost: Int) {
    PEPSI(1, "Pepsi", 100),
    MARS(2, "Mars", 55);

    var code = code
    var itemName = itemName
    var cost = cost

}
