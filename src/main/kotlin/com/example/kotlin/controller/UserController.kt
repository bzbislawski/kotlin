package com.example.kotlin.controller

import com.example.kotlin.model.User
import com.example.kotlin.service.PdfGeneratorUtil
import com.example.kotlin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    lateinit var pdfGeneratorUtil: PdfGeneratorUtil

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/users")
    fun index(): MutableIterable<User> {
        return userService.findAll()
    }

    @GetMapping("/users/{id}")
    fun find(@PathVariable id: Int) =  userService.find(id)

    @PostMapping("/users")
    fun submit(@RequestBody user: User): User? {
        return userService.add(user)
    }

    @GetMapping(value = ["/file"])
    fun generateFile(@RequestParam(value = "name", defaultValue = "Mr. Noname") name: String) {
        val data = mapOf("name" to name)
        pdfGeneratorUtil.createPdf("template", data)
    }
}