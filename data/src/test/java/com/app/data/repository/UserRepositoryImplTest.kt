package com.app.data.repository

import com.app.common.Resource
import com.app.data.remote.UserApiService
import com.app.data.remote.UserDto
import com.app.data.remote.UserResponseDto
import com.app.domain.model.UserItem
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.collections.listOf
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class UserRepositoryImplTest {

    private lateinit var repository: UserRepositoryImpl
    private val apiService = mockk<UserApiService>()

    @Before
    fun setup() {
        repository = UserRepositoryImpl(apiService)
    }

    @Test
    fun `getUserList emits Resources success when api call is successful`() = runTest {
        // Arrange
        val apiResponse = UserResponseDto(
            users = listOf(
                UserDto(
                    1,
                    "Emily",
                    "Johnson",
                    "emily.johnson@x.dummyjson.com",
                    "+81 965-431-3024",
                    "https://dummyjson.com/icon/emilys/128"
                )
            )
        )
        val expectedDomaininModel = listOf(UserItem(
            1,
            "Emily",
            "Johnson",
            "emily.johnson@x.dummyjson.com",
            "+81 965-431-3024",
            "https://dummyjson.com/icon/emilys/128"))
        coEvery { apiService.getUserList() } returns apiResponse


        val emissions = repository.getUserList().toList()


        assert(emissions[0] is Resource.Loading)
        assert(emissions[1] is Resource.Success)
        val successResult = emissions[1] as Resource.Success
        assertEquals(expectedDomaininModel, successResult.data)
        coEvery { apiService.getUserList() }
    }

    @Test
    fun `getUser emits Resource Error when api call throws exception`() = runTest {
        val exceptionMessage = "Network error"
        // Arrange
        coEvery { apiService.getUserList() } throws RuntimeException(exceptionMessage)

        // Act
        val emissions = repository.getUserList().toList()

        // Assert
        assert(emissions[0] is Resource.Loading)
        assert(emissions[1] is Resource.Error)
        assertEquals(exceptionMessage,(emissions[1] as Resource.Error).message)
        coEvery { apiService.getUserList() }
        /*val errorMessage = (emissions[1] as Resource.Error).message
        assertEquals(exceptionMessage, errorMessage)*/
    }
}
