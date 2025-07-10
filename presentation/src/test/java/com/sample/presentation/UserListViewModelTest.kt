package com.sample.presentation

import com.app.common.Resource
import com.app.domain.model.UserItem
import com.app.domain.usecase.GetUserListUseCase
import com.sample.presentation.viewmodel.UserListViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserListViewModelTest {
    private lateinit var viewModel : UserListViewModel
    private var getUserListUseCase : GetUserListUseCase = mockk()

    private val standardTestDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(standardTestDispatcher)
        getUserListUseCase = mockk(relaxed = true)
        viewModel = UserListViewModel(getUserListUseCase)
    }

    @Test
    fun `fetchUserList emit user list successfully` () = runTest {
        //Given
        val users = listOf(UserItem(
            1,
            "Emily",
            "Johnson",
            "emily.johnson@x.dummyjson.com",
            "+81 965-431-3024",
            "https://dummyjson.com/icon/emilys/128"),
            UserItem(
                2,
                "Michael",
                "Williams",
                "michael.williams@x.dummyjson.com",
                "+49 258-627-6644",
                "https://dummyjson.com/icon/michaelw/128"))
        val flow = flowOf(Resource.Success(users))
        coEvery{getUserListUseCase()} returns  flow
        viewModel.fetchUserList()
        standardTestDispatcher.scheduler.advanceUntilIdle()
        val result = viewModel.userList.first()

        assert(result is Resource.Success)
        assert((result as Resource.Success).data==users)
        coEvery{getUserListUseCase()}
    }

    @Test
    fun `fetchUserList emit error when use case fail` () = runTest {
         val errorMessage = "Network error"
        val flow = flowOf(Resource.Error<List<UserItem>>(message = errorMessage))
        coEvery { getUserListUseCase() } returns flow
        viewModel.fetchUserList()
        standardTestDispatcher.scheduler.advanceUntilIdle()
        val result = viewModel.userList.first()

        assertTrue (result is Resource.Error)
        assertEquals(errorMessage,(result as Resource.Error).message)
        coEvery { getUserListUseCase() }
    }
}