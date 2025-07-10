package com.app.domain.repository

import com.app.domain.model.UserItem
import com.app.common.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserList(): Flow<Resource<List<UserItem>>>
}