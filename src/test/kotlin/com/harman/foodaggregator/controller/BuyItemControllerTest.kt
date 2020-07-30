package com.harman.foodaggregator.controller


import com.harman.foodaggregator.service.BuyItemService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.web.client.RestTemplate

/**
 * It is Test class of BuyItemController to test the request
 *
 */
internal class BuyItemControllerTest {

    private lateinit var obj: BuyItemController

    @BeforeEach
    fun setUp() {

        this.obj = BuyItemController()
        this.obj.buyItemService = BuyItemService()
        this.obj.buyItemService.restTemplate = RestTemplate()

    }

    @Test
    fun buyItem() {

        val actual = obj.buyItem("Apple")
        assertEquals(2, actual.size)

    }


    @Test
    fun buyItemQtyPrice() {

        val actual = obj.buyItemQtyPrice("Carrot", 10, 70.1)
        assertEquals(1, actual.size)

    }

    @Test
    fun fastBuyItem() {
        val actual = obj.fastBuyItem("Apple")
        assertEquals(2, actual.size)
    }
}