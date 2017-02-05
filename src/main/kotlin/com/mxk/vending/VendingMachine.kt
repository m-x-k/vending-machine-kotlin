package com.mxk.vending

import com.mxk.vending.enums.Coin
import com.mxk.vending.enums.Item
import com.mxk.vending.exceptions.EmptyFundsException
import com.mxk.vending.exceptions.InsufficientFundsException
import com.mxk.vending.exceptions.NotFoundException

class VendingMachine {

    fun purchaseItem(code: Int, money: Array<Coin>): Result {
        val funds: Int = getTotalFundsAvailable(money)
        val item = purchaseItemWithFunds(code, funds)

        return Result(item, calculateChange(item, funds))
    }

    private fun purchaseItemWithFunds(code: Int, amount: Int): Item {
        val item = findItem(code)
        if (item.cost > amount)
            throw InsufficientFundsException("More funds required")
        return item
    }

    private fun getTotalFundsAvailable(money: Array<Coin>): Int {
        val total: Int = calculateTotal(money)
        if (total <= 0)
            throw EmptyFundsException("Money required!: " + total)
        return total
    }

    private fun findItem(code: Int): Item {
        Item.values()
                .filter { it.code == code }
                .forEach { return it }
        throw NotFoundException("Unknown Item Selected")
    }

    private fun calculateChange(i: Item, amount: Int): Int {
        return amount - i.cost
    }

    private fun calculateTotal(money: Array<Coin>): Int {
        val total: Int = money.sumBy { it.pence }

        return total
    }

}

data class Result(val item: Item, val change: Int)

