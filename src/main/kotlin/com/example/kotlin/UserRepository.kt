package com.example.kotlin

import com.example.kotlin.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface UserRepository: CrudRepository<User, Repository> {
}
