package com.app.data.remote

data class UserResponseDto(
    val users: List<UserDto>
)

data class UserDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email : String,
    val phone : String,
    val image: String

)
