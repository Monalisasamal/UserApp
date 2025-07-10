package com.sample.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.app.common.NavigationObjects
import com.app.domain.model.UserItem
import com.sample.presentation.viewmodel.UserListViewModel
import com.sample.presentation.R


@Composable
fun UserDetailScreen(
    navController: NavHostController,
    backStackEntry: NavBackStackEntry
) {
    val parentEntry = remember(backStackEntry) {
        navController.getBackStackEntry(NavigationObjects.UserList.nav)
    }
    val viewModel: UserListViewModel = hiltViewModel(parentEntry)
    val selectedUser = viewModel.selectedUser.collectAsState().value

    selectedUser?.let { userItem ->
        UserDetailContent(userItem = userItem, navController = navController)
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(stringResource(id = R.string.no_user), color = Color.Magenta)
        }
    }
}

@Composable
fun UserDetailContent(userItem: UserItem, navController: NavHostController) {
    Column {
        HeaderView(stringResource(R.string.details), navController)
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.height_16dp))) {
            AsyncImage(
                model = userItem.image,
                contentDescription = userItem.firstName,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.height_200dp))
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.height_15dp)))

            Text(text = userItem.firstName+ " "+ userItem.lastName,
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_8dp)))

            Text(text = userItem.email,
                style = MaterialTheme.typography.bodyLarge,
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_8dp)))

            Text(
                text = userItem.phone,
                style = MaterialTheme.typography.bodyLarge,
            )

        }
    }

}



