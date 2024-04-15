package com.ortega.tshombo.feature.user.presentation.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.AdminActivity
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.MTextButton
import com.ortega.tshombo.core.common.components.MTextField
import com.ortega.tshombo.core.common.components.NavigationIconButton
import com.ortega.tshombo.feature.user.domain.request.UserRequest
import com.ortega.tshombo.feature.user.presentation.viewModel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUserScreen(userViewModel: UserViewModel, onClickBack: () -> Unit) {

    val context = LocalContext.current

    val nameField = remember { mutableStateOf("") }
    val emailField = remember { mutableStateOf("") }
    val passwordField = remember { mutableStateOf("") }

    val loading = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            MediumTopAppBar(
                navigationIcon = { NavigationIconButton { onClickBack() } },
                title = {
                    MText(
                        text = stringResource(R.string.add_user),
                        fontWeight = FontWeight.Bold,
                    )
                },
                actions = {
                    MTextButton(
                        text = stringResource(id = R.string.add),
                        loading = loading.value,
                        onClick = {
                            if (
                                nameField.value.isNotEmpty() &&
                                emailField.value.isNotEmpty() &&
                                passwordField.value.isNotEmpty()
                            ) {

                                val userRequest = UserRequest(
                                    username = nameField.value,
                                    email = emailField.value,
                                    password = passwordField.value,
                                )

                                userViewModel.addUser(
                                    userRequest = userRequest,
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
                                    },
                                )
                            }
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
                label = stringResource(R.string.email),
                value = emailField.value,
                onValueChange = { emailField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.password),
                value = passwordField.value,
                onValueChange = { passwordField.value = it },
            )
        }
    }
}