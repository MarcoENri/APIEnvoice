package com.example.enterpriceAPI.controller


import com.example.enterpriceAPI.model.User
import com.example.enterpriceAPI.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
     lateinit var  userService: UserService
    @GetMapping
    fun list(): List<User>{
        return userService.list()
    }

    @PostMapping
    fun save(@RequestBody user: User): User{
        return userService.save(user)
    }

    @PutMapping
    fun update(@RequestBody user: User):ResponseEntity <User>{
        return ResponseEntity(userService.update(user), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody user: User):ResponseEntity<User>{
        return ResponseEntity(userService.update(user), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity<String>{
        userService.delete(id)
        return ResponseEntity("Usuario Eliminado" ,HttpStatus.OK)
    }

}