package com.example.kotlin.service

import com.example.kotlin.repository.UserRepository
import com.example.kotlin.model.User
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {


    fun add(user: User): User = userRepository.save(user)

    fun findAll() = userRepository.findAll()

    fun find(id: Int) = userRepository.findById(id)
}
