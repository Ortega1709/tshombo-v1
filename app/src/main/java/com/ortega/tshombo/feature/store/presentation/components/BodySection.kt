package com.ortega.tshombo.feature.store.presentation.components

import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.PromotionActivity
import com.ortega.tshombo.StoreActivity
import com.ortega.tshombo.core.common.components.Empty
import com.ortega.tshombo.core.common.components.Item
import com.ortega.tshombo.core.common.components.Loading
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.feature.store.presentation.state.StoresUiState
import com.ortega.tshombo.feature.store.presentation.viewModel.StoreViewModel
import com.ortega.tshombo.feature.user.presentation.state.UsersUiState
import com.ortega.tshombo.feature.user.presentation.viewModel.UserViewModel

@Composable
fun BodySection(
    storesUiState: StoresUiState,
    paddingValues: PaddingValues,
    storeViewModel: StoreViewModel
) {

    val context = LocalContext.current

    if (storesUiState.loading) Loading(paddingValues = paddingValues)
    else {
        if (storesUiState.users.isEmpty()) Empty(paddingValues = paddingValues)
        else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                item { Spacer(modifier = Modifier.height(16.dp)) }
                items(storesUiState.users) {
                    Item(
                        overlineContent = { MText(text = it.city) },
                        leadingContent = { },
                        headlineContent = { MText(text = it.name) },
                        supportingContent = { MText(text = "${it.commune}/${it.avenue}") },
                        onClickDelete = null,
                        onClickUpdate = null,
                        onClick = {
                            val intent = Intent(context, PromotionActivity::class.java)
                            intent.putExtra("storeId", it.storeId)
                            context.startActivity(intent)
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    Spacer(modifier = Modifier.height(70.dp))
                }
            }
        }
    }
}
