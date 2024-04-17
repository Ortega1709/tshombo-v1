package com.ortega.tshombo.feature.store.presentation.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.tshombo.AdminActivity
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.MTextButton
import com.ortega.tshombo.core.common.components.MTextField
import com.ortega.tshombo.core.common.components.NavigationIconButton
import com.ortega.tshombo.feature.home.domain.entity.StoreEntity
import com.ortega.tshombo.feature.store.domain.request.LocationRequest
import com.ortega.tshombo.feature.store.domain.request.StoreRequest
import com.ortega.tshombo.feature.store.presentation.viewModel.StoreViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStoreScreen(
    storeViewModel: StoreViewModel = hiltViewModel(),
    userId: Int,
    onClickBack: () -> Unit
) {

    val nameField = remember { mutableStateOf("") }
    val cityField = remember { mutableStateOf("") }
    val avenueField = remember { mutableStateOf("") }
    val communeField = remember { mutableStateOf("") }
    val rccmField = remember { mutableStateOf("") }
    val lonField = remember { mutableStateOf("") }
    val latField = remember { mutableStateOf("") }

    val loading = remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            MediumTopAppBar(
                navigationIcon = { NavigationIconButton { onClickBack() } },
                title = {
                    MText(
                        text = stringResource(R.string.add_store),
                        fontWeight = FontWeight.Bold,
                    )
                },
                actions = {
                    MTextButton(
                        text = stringResource(id = R.string.add),
                        loading = loading.value,
                        onClick = {
                            val storeRequest = StoreRequest(
                                name = nameField.value,
                                city = cityField.value,
                                avenue = avenueField.value,
                                commune = communeField.value,
                                rccm = rccmField.value,
                                location = LocationRequest(
                                    lat = latField.value.toDouble(),
                                    lon = lonField.value.toDouble()
                                )
                            )

                            storeViewModel.addStore(
                                userId = userId,
                                storeRequest = storeRequest,
                                onSuccess = {
                                    val intent = Intent(context, AdminActivity::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                                            Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    context.startActivity(intent)
                                },
                                onError = {
                                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                },
                                loading = {
                                    loading.value = it
                                }
                            )
                        },
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            MTextField(
                label = stringResource(id = R.string.name),
                value = nameField.value,
                onValueChange = { nameField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.city),
                value = cityField.value,
                onValueChange = { cityField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.avenue),
                value = avenueField.value,
                onValueChange = { avenueField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.commune),
                value = communeField.value,
                onValueChange = { communeField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.rccm),
                value = rccmField.value,
                onValueChange = { rccmField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.longitude),
                value = lonField.value,
                onValueChange = { lonField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.latitude),
                value = latField.value,
                onValueChange = { latField.value = it },
            )
        }
    }
}