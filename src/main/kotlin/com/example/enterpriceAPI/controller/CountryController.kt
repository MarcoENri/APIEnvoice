package com.example.enterpriceAPI.controller

import com.example.enterpriceAPI.model.Country
import com.example.enterpriceAPI.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/country")
class CountryController {
    @Autowired
     lateinit var  countryService: CountryService
    @GetMapping
    fun list(): List<Country>{
        return countryService.list()
    }

    @PostMapping
    fun save(@RequestBody country: Country): Country{
        return countryService.save(country)
    }

    @PutMapping
    fun update(@RequestBody country: Country):ResponseEntity <Country>{
        return ResponseEntity(countryService.update(country), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody country: Country):ResponseEntity<Country>{
        return ResponseEntity(countryService.update(country), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity<String>{
        countryService.delete(id)
        return ResponseEntity("Pais Eliminado" ,HttpStatus.OK)
    }

}