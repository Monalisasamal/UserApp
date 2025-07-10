package com.sample.presentation.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.sample.presentation.viewmodel.UserListViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.app.common.NavigationObjects
import com.app.common.Resource
import com.sample.presentation.R
import kotlin.collections.orEmpty

@Composable
fun UserListScreen(
    navController: NavController,
    viewModel: UserListViewModel = hiltViewModel()
) {

    val userListState = viewModel.userList.collectAsState()
    Log.d("responces",userListState.value.data.toString())

    when (val result = userListState.value) {
        is Resource.Loading -> ShowLoaderView()
        is Resource.Success -> Column {
            HeaderView(stringResource(id = R.string.header), navController)
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Ensure this takes remaining space
            ) {
                val userList = result.data.orEmpty()
                items(userList.size) { index ->
                    val item = userList[index]
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                viewModel.setSelectedUser(item)
                                navController.navigate(NavigationObjects.Details.nav)
                            }
                            .padding(dimensionResource(R.dimen.padding_8dp)),
                           verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(item.image),
                            contentDescription = item.firstName,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(dimensionResource(R.dimen.height_100dp))
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_8dp)))
                        Column {
                            Text(text = item.firstName+ " "+ item.lastName,
                                style = MaterialTheme.typography.titleLarge,
                            )
                            Text(text = item.email,
                                style = MaterialTheme.typography.bodyLarge,
                            )
                            Text(text = item.phone,
                                style = MaterialTheme.typography.bodyLarge,
                            )
                        }

                    }
                }
            }
        }

        is Resource.Error -> ShowErrorView(result.message)
    }
}



