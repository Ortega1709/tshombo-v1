package com.ortega.tshombo.feature.auth.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MButton
import com.ortega.tshombo.core.theme.TshomboTheme
import com.ortega.tshombo.feature.auth.presentation.component.AuthSubtitle
import com.ortega.tshombo.feature.auth.presentation.component.AuthTextField
import com.ortega.tshombo.feature.auth.presentation.component.AuthTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(onClickBack: () -> Unit) {
    val nameField = remember { mutableStateOf("") }
    val emailField = remember { mutableStateOf("") }
    val passwordField = remember { mutableStateOf("") }

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                    }
                },
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            AuthTitle(text = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(16.dp))
            AuthSubtitle(text = stringResource(id = R.string.enter_valid_information))
            Spacer(modifier = Modifier.height(16.dp))
            AuthTextField(
                label = stringResource(R.string.name),
                value = nameField.value,
                onValueChange = { value -> nameField.value = value },
            )
            Spacer(modifier = Modifier.height(16.dp))
            AuthTextField(
                label = stringResource(id = R.string.email),
                value = emailField.value,
                onValueChange = { value -> emailField.value = value },
            )
            Spacer(modifier = Modifier.height(16.dp))
            AuthTextField(
                label = stringResource(id = R.string.password),
                value = passwordField.value,
                onValueChange = { value -> passwordField.value = value },
            )
            Spacer(modifier = Modifier.height(16.dp))
            MButton(
                text = stringResource(id = R.string.create_account),
                onClick = {
                    if (
                        nameField.value.isNotEmpty() &&
                        emailField.value.isNotEmpty() &&
                        passwordField.value.isNotEmpty()) {

                        // TODO: Logic for register

                    } else {
                        Toast.makeText(context, "All field are required", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    TshomboTheme {
        RegisterScreen(onClickBack = {})
    }
}