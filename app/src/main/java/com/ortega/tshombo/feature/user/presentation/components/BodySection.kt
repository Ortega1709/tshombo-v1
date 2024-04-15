package com.ortega.tshombo.feature.user.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.core.common.components.Empty
import com.ortega.tshombo.core.common.components.Item
import com.ortega.tshombo.core.common.components.Loading
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.feature.user.presentation.state.UsersUiState

@Composable
fun BodySection(usersUiState: UsersUiState, paddingValues: PaddingValues) =
    if (usersUiState.loading) Loading(paddingValues = paddingValues)
    else {
        if (usersUiState.users.isEmpty()) Empty(paddingValues = paddingValues)
        else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                item { Spacer(modifier = Modifier.height(16.dp)) }
                items(usersUiState.users) {
                    Item(
                        overlineContent = { MText(text = it.role.name) },
                        leadingContent = {},
                        headlineContent = { MText(text = it.email) },
                        supportingContent = { MText(text = it.username) },
                        onClickDelete = {},
                        onClickUpdate = null
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    Spacer(modifier = Modifier.height(70.dp))
                }
            }
        }
    }