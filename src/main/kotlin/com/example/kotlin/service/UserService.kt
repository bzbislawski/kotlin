package com.example.kotlin.service

import com.example.kotlin.model.User
import org.springframework.stereotype.Service

@Service
class UserService {

    private var users = mutableListOf(
            User(1, "Bart", 30),
            User(2, "TJ", 10)
    )

    fun add(user: User) = users.add(user)

    fun findAll() = users

    fun find(id: Int) = users.find { it.id == id }
}
