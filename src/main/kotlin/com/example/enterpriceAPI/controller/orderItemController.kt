package com.example.enterpriceAPI.controller

import com.example.enterpriceAPI.model.orderItem
import com.example.enterpriceAPI.service.orderItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orderItem")
class orderItemController {
    @Autowired
     lateinit var  orderItemService: orderItemService
    @GetMapping
    fun list(): List<orderItem>{
        return orderItemService.list()
    }

    @PostMapping
    fun save(@RequestBody orderItem: orderItem): orderItem{
        return orderItemService.save(orderItem)
    }

    @PutMapping
    fun update(@RequestBody orderItem: orderItem):ResponseEntity <orderItem>{
        return ResponseEntity(orderItemService.update(orderItem), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody orderItem: orderItem):ResponseEntity<orderItem>{
        return ResponseEntity(orderItemService.update(orderItem), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity<String>{
        orderItemService.delete(id)
        return ResponseEntity("Articulo Eliminado" ,HttpStatus.OK)
    }

}