package com.harman.foodaggregator.service

import com.harman.foodaggregator.controller.BuyItemController
import com.harman.foodaggregator.model.Fruit
import com.harman.foodaggregator.model.Vegetable
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.springframework.web.client.RestTemplate

internal class BuyItemServiceTest {


    private lateinit var obj: BuyItemService

    @BeforeEach
    fun setUp() {
        this.obj = BuyItemService()
        obj.restTemplate= RestTemplate()

    }

    @Test
    fun getItemsTest() {
        val expect: ArrayList<Fruit> = ArrayList<Fruit>()

        expect.add(Fruit("24-583-0264","Apple",30,"\$62.02"))
        expect.add(Fruit("75-588-0160","Apple",28,"\$86.41"))

        val actual = obj.getItems("Apple")
        assertEquals(expect.size,actual.size)
    }

    @Test
    fun getItemsNegativeTest() {
        val expect: ArrayList<Any> = ArrayList<Any>()

        expect.add("NOT_FOUND")
        val actual = obj.getItems("")

        assertEquals(expect.get(0),actual.get(0))
    }
    @Test
    fun getItemByQtyPriceTest() {
        val expect: ArrayList<Vegetable> = ArrayList<Vegetable>()

        expect.add(Vegetable("76-152-3057","Carrot",13,"\$71.01"))


        val actual = obj.getItemByQtyPrice("Carrot",10,70.1)
        assertEquals(expect.get(0).toString(),actual.get(0).toString())

    }

    @Test
    fun getItemByQtyPriceNegativeTest() {
        val expect: ArrayList<Any> = ArrayList<Any>()

        expect.add("NOT_FOUND")


        val actual = obj.getItemByQtyPrice("Carrot",15,75.1)
        assertEquals(expect.get(0).toString(),actual.get(0).toString())

    }

    @Test
    fun getFastBuyItemsTest() {
        val expect: ArrayList<Vegetable> = ArrayList<Vegetable>()

        expect.add(Vegetable("76-152-3057","Carrot",13,"\$71.01"))
        val actual = obj.getFastBuyItems("Carrot")
        assertEquals(expect.get(0).toString(),actual.get(0).toString())

    }
    @Test
    fun getFastBuyItemsNegativeTest() {
        val expect: ArrayList<Any> = ArrayList<Any>()

        expect.add("NOT_FOUND")
        val actual = obj.getFastBuyItems("")
        assertEquals(expect.get(0).toString(),actual.get(0).toString())

    }

}