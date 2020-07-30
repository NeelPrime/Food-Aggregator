package com.harman.foodaggregator.controller

import com.harman.foodaggregator.service.BuyItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * This Rest Controller accepts request of buy-item
 *
 * @author Neel
 *
 */

@RestController
class BuyItemController {

    @Autowired lateinit var buyItemService:BuyItemService

    /**
     * This is home page initialization.
     *
     * @return String
     */
    @RequestMapping("/")
    fun home():String
    {
        return "Welcome User"
    }

    /**
     * It accepts item name as parameter and returns the appropriate item
     *
     * @return List of Items
     */
    @RequestMapping("/buy-item")
    fun buyItem(@RequestParam("name")name:String): List<Any> {
        return buyItemService.getItems(name)
    }
    /**
     * It accepts item name,quantity and price as parameter and returns the appropriate item
     *
     * @return List of Items
     */
    @RequestMapping("/buy-item-qty-price")
    fun buyItemQtyPrice(@RequestParam("item")item:String,@RequestParam("quantity")quantity:Int,@RequestParam("price")price:Double): List<Any> {
        return buyItemService.getItemByQtyPrice(item,quantity,price)
    }
    /**
     * It accepts item name as parameter and returns the appropriate item as soon as possible
     *
     * @return List of Items
     */
    @RequestMapping("/fast-buy-item")
    fun fastBuyItem(@RequestParam("name")name:String): List<Any> {

        return buyItemService.getFastBuyItems(name)
    }


}