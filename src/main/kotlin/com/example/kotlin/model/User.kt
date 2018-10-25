package com.example.kotlin.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(@Id @GeneratedValue(strategy= GenerationType.AUTO) val id: Int, val name: String, val age: Int)
