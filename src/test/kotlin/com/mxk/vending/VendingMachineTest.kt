package com.mxk.vending

import com.mxk.vending.enums.*
import com.mxk.vending.exceptions.EmptyFundsException
import com.mxk.vending.exceptions.InsufficientFundsException
import com.mxk.vending.exceptions.NotFoundException
import org.junit.Assert.assertEquals
import org.junit.Test

class VendingMachineTest {

    @Test
    fun purchaseItem_success() {
        var v = VendingMachine()
        var inputCode = 1
        var money = arrayOf(Coin.POUND)
        val (item, change) = v.purchaseItem(inputCode, money)

        assertEquals(1, item.code)
        assertEquals("PEPSI", item.name)
        assertEquals(100, item.cost)
        assertEquals(0, change)
    }

    @Test
    fun purchaseItem_WithChangeReturned() {
        var v = VendingMachine()
        var inputCode = 2
        var money = arrayOf(Coin.FIFTY, Coin.FIFTY)
        val (item, change) = v.purchaseItem(inputCode, money)

        assertEquals(2, item.code)
        assertEquals("MARS", item.name)
        assertEquals(55, item.cost)
        assertEquals(45, change)
    }

    @Test(expected = NotFoundException::class)
    fun purchaseItem_NotFoundException() {
        var v = VendingMachine()
        var inputCode = -1
        v.purchaseItem(inputCode, arrayOf(Coin.POUND))
    }

    @Test(expected = EmptyFundsException::class)
    fun purchaseItem_EmptyFundsException() {
        var v = VendingMachine()
        var inputCode = 1
        v.purchaseItem(inputCode, arrayOf())
    }

    @Test(expected = InsufficientFundsException::class)
    fun purchaseItem_NotEnoughMoney_InsufficientFundsException() {
        var v = VendingMachine()
        var inputCode = 1
        v.purchaseItem(inputCode, arrayOf(Coin.ONE))
    }
}


