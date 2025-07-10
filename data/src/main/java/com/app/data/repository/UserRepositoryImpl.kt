package com.app.data.repository

import com.app.common.Resource
import com.app.data.mapper.toDomain
import com.app.data.remote.UserApiService
import com.app.domain.model.UserItem
import com.app.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: UserApiService
) : UserRepository {
    override fun getUserList(): Flow<Resource<List<UserItem>>> = flow {
        try {
            emit(Resource.Loading()) // Emit loading state
            val response = apiService.getUserList()
            val items = response.users.map { it.toDomain() }

            emit(Resource.Success(items)) // Emit success state
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString())) // Emit error state
        }
    }


}
