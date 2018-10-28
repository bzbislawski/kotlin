package com.example.kotlin.repository

import com.example.kotlin.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Int>
