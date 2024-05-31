package com.example.enterpriceAPI.controller


import com.example.enterpriceAPI.model.Order
import com.example.enterpriceAPI.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController {
    @Autowired
     lateinit var  orderService: OrderService
    @GetMapping
    fun list(): List<Order>{
        return orderService.list()
    }

    @PostMapping
    fun save(@RequestBody order: Order): Order{
        return orderService.save(order)
    }

    @PutMapping
    fun update(@RequestBody order: Order):ResponseEntity <Order>{
        return ResponseEntity(orderService.update(order), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody order: Order):ResponseEntity<Order>{
        return ResponseEntity(orderService.update(order), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity<String>{
        orderService.delete(id)
        return ResponseEntity("Orden Eliminado" ,HttpStatus.OK)
    }

}