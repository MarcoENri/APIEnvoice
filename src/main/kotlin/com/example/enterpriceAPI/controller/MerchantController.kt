package com.example.enterpriceAPI.controller

import com.example.enterpriceAPI.model.Merchant
import com.example.enterpriceAPI.service.MerchantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/merchant")
class MerchantController {
    @Autowired
     lateinit var  merchantService: MerchantService
    @GetMapping
    fun list(): List<Merchant>{
        return merchantService.list()
    }

    @PostMapping
    fun save(@RequestBody merchant: Merchant): Merchant{
        return merchantService.save(merchant)
    }

    @PutMapping
    fun update(@RequestBody merchant: Merchant):ResponseEntity <Merchant>{
        return ResponseEntity(merchantService.update(merchant), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody merchant: Merchant):ResponseEntity<Merchant>{
        return ResponseEntity(merchantService.update(merchant), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity<String>{
        merchantService.delete(id)
        return ResponseEntity("Articulo Eliminado" ,HttpStatus.OK)
    }

}