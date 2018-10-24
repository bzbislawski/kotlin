package com.example.kotlin.controller

import com.example.kotlin.model.User
import com.example.kotlin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/")
    fun index(): List<User> {
        return userService.findAll()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int) : User? {
        return userService.find(id)
    }

    @PostMapping("/submit")
    fun submit(@RequestBody user: User): Boolean {
        return userService.add(user)
    }
}