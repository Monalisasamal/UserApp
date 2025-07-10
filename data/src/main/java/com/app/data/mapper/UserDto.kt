package com.app.data.mapper

import com.app.data.remote.UserDto
import com.app.domain.model.UserItem

fun UserDto.toDomain(): UserItem {
    return UserItem(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email,
        phone = this.phone,
        image= this.image
    )
}