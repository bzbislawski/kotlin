package com.example.kotlin.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) val id: Int,
        val username: String,
        val password: String,
        val firstName: String,
        val lastName: String,
        val age: Int
)
