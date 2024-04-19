package com.ortega.tshombo.feature.myStore.presentation.screens

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.ortega.tshombo.AddPhoneActivity
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.Loading
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.theme.Blue
import com.ortega.tshombo.core.theme.White
import com.ortega.tshombo.feature.myStore.presentation.components.BodySection
import com.ortega.tshombo.feature.myStore.presentation.components.NotHaveStore
import com.ortega.tshombo.feature.myStore.presentation.viewModel.MyStoreViewModel
import com.ortega.tshombo.feature.store.presentation.viewModel.StoreViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyStoreScreen(myStoreViewModel: MyStoreViewModel = hiltViewModel()) {
    val myStoreUiState by myStoreViewModel.myStoreUiState
    val context = LocalContext.current

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = {
                    MText(
                        text = stringResource(R.string.my_store),
                        fontWeight = FontWeight.Bold,
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            if (myStoreUiState.store != null) {
                FloatingActionButton(onClick = {

                    val intent = Intent(context, AddPhoneActivity::class.java)
                    intent.putExtra("storeId", myStoreUiState.store!!.storeId)
                    context.startActivity(intent)

                }, containerColor = Blue) {
                    Icon(imageVector = Icons.Rounded.Add, tint = White, contentDescription = null)
                }
            }
        }
    ) {
        if (myStoreUiState.loading) Loading(paddingValues = it)
        else {
            if (myStoreUiState.store == null) NotHaveStore(
                paddingValues = it,
                myStoreViewModel = myStoreViewModel
            )
            else {
                BodySection(
                    paddingValues = it,
                    myStoreViewModel = myStoreViewModel,
                    storeEntity = myStoreUiState.store!!
                )
            }
        }
    }
}