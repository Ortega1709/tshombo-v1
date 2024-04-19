package com.ortega.tshombo.core.common.components

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
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.MTextButton
import com.ortega.tshombo.feature.home.presentation.viewModel.HomeViewModel

@Composable
fun ErrorFound(onClickRetry: () -> Unit, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        MText(text = "Oups quelque chose s'est mal passé")
        Spacer(modifier = Modifier.height(8.dp))
        MTextButton(
            text = stringResource(id = R.string.retry),
            onClick = onClickRetry,
        )

    }
}