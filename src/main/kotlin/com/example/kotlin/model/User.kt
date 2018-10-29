package com.example.kotlin.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY) val id: Int,
        val username: String? = null,
        val password: String? = null,
        val firstName: String? = null,
        val lastName: String? = null,
        val age: Int? = null
)
