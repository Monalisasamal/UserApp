package com.sample.presentation.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.common.Resource
import com.app.domain.model.UserItem
import com.app.domain.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModel() {
    private val _userList = MutableStateFlow<Resource<List<UserItem>>>(Resource.Loading())
    val userList: StateFlow<Resource<List<UserItem>>> = _userList
    private val _selectedUser = MutableStateFlow<UserItem?>(null)
    val selectedUser: StateFlow<UserItem?> = _selectedUser
    init {
        fetchUserList()
    }
    fun fetchUserList() {
        try {
            viewModelScope.launch {
                getUserListUseCase().collect { resource ->
                    _userList.value = resource
                } }
        } catch (e: Exception) {
            Log.e(TAG,e.message.toString())
        }
        }
    fun setSelectedUser(user: UserItem) {
        _selectedUser.value = user
    }

}
