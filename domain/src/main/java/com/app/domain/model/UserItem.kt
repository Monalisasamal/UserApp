package com.app.domain.model

data class UserItem(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val image: String?
)
