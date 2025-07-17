package com.app.data.repository

import android.content.Context
import com.app.common.Resource
import com.app.data.R
import com.app.data.mapper.toDomain
import com.app.data.remote.UserApiService
import com.app.domain.model.UserItem
import com.app.domain.repository.UserRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: UserApiService,
    @ApplicationContext private val context: Context
) : UserRepository {
    override fun getUserList(): Flow<Resource<List<UserItem>>> = flow {
        try {
            emit(Resource.Loading()) // Emit loading state
            val response = apiService.getUserList()
            val items = response.users.map { it.toDomain() }

            emit(Resource.Success(items)) // Emit success state
        } catch (e: Exception) {
            val errorMessage = when (e) {
                is IOException -> context.getString(R.string.check_internet)
                is HttpException -> {
                    when (e.hashCode()) {
                        400 -> context.getString(R.string.error_400)
                        401 -> context.getString(R.string.error_401)
                        404 -> context.getString(R.string.error_404)
                        500 -> context.getString(R.string.error_500)
                        else -> context.getString(R.string.unexcepted_error)+ e.message.toString()
                    }
                }
                else -> context.getString(R.string.unexcepted_error)
            }
            emit(Resource.Error(errorMessage)) // Emit error state
        }
    }


}
