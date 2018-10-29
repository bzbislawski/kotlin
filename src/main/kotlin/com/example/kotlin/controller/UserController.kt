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

    @GetMapping(value = ["/get-file"])
    fun generateFile(
            @RequestParam(value = "username") username: String?,
            @RequestParam(value = "firstName") firstName: String?,
            @RequestParam(value = "lastName") lastName: String?,
            @RequestParam(value = "age") age: Int?
    ) {
        val data = mapOf(
                "username" to username,
                "firstName" to firstName,
                "lastName" to lastName,
                "age" to age
        )
        pdfGeneratorUtil.createPdf("template", data)
    }

    @PostMapping(value = ["/post-file"])
    fun generateFile2(@RequestBody user: User) {
        val data = mapOf(
                "username" to user.username,
                "firstName" to user.firstName,
                "lastName" to user.lastName,
                "age" to user.age
        )
        pdfGeneratorUtil.createPdf("template", data)
    }
}