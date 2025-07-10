package com.app.domain.usecase

import com.app.common.Resource
import com.app.domain.model.UserItem
import com.app.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserListUseCase(private val repository: UserRepository) {
    operator fun invoke(): Flow<Resource<List<UserItem>>> {
        return repository.getUserList()
    }
}