package com.mxk.vending

import com.mxk.vending.enums.Coin
import com.mxk.vending.enums.Item
import com.mxk.vending.exceptions.EmptyFundsException
import com.mxk.vending.exceptions.InsufficientFundsException
import com.mxk.vending.exceptions.NotFoundException

class VendingMachine {

    fun purchaseItem(code: Int, money: Array<Coin>): Result {
        var funds: Int = getTotalFundsAvailable(money)

        var item = purchaseItemWithFunds(code, funds)

        return Result(item, calculateChange(item, funds))
    }

    private fun purchaseItemWithFunds(code: Int, amount: Int): Item {
        var item = findItem(code)
        if (item.cost > amount)
            throw InsufficientFundsException("More funds required")
        return item
    }

    private fun getTotalFundsAvailable(money: Array<Coin>): Int {
        var total: Int = calculateTotal(money)
        if (total <= 0)
            throw EmptyFundsException("Money required!: " + total)
        return total
    }

    private fun findItem(code: Int): Item {
        for (i in Item.values()) {
            if (i.code == code) {
                return i
            }
        }
        throw NotFoundException("Unknown Item Selected")
    }

    private fun calculateChange(i: Item, amount: Int): Int {
        return amount - i.cost
    }

    private fun calculateTotal(money: Array<Coin>): Int {
        var total: Int = 0
        for (m in money) {
            total += m.pence
        }

        return total
    }

}

data class Result(val item: Item, val change: Int)

