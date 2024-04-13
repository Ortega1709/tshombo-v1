package com.ortega.tshombo.feature.user.presentation.screens

import android.annotation.SuppressLint
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.MTextButton
import com.ortega.tshombo.core.common.components.MTextField
import com.ortega.tshombo.core.common.components.NavigationIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUserScreen(onClickBack: () -> Unit) {

    val nameField = remember { mutableStateOf("") }
    val emailField = remember { mutableStateOf("") }
    val passwordField = remember { mutableStateOf("") }
    val userTypeField = remember { mutableStateOf("") }

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
                    MTextButton(text = stringResource(id = R.string.add)) {

                    }
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
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.user_type),
                value = userTypeField.value,
                onValueChange = { userTypeField.value = it },
            )
        }
    }
}