package com.ortega.tshombo.feature.myStore.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MButton
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.MTextButton
import com.ortega.tshombo.feature.myStore.presentation.viewModel.MyStoreViewModel

@Composable
fun NotHaveStore(paddingValues: PaddingValues, myStoreViewModel: MyStoreViewModel) {
    Column (
        Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues), Arrangement.Center, Alignment.CenterHorizontally
    ) {
        MText(text = stringResource(R.string.dont_have_store))
        Spacer(modifier = Modifier.height(8.dp))
        MTextButton(text = stringResource(R.string.retry), onClick = {
            myStoreViewModel.getStoreByUserId()
        })
    }
}