package com.ortega.tshombo.feature.myStore.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.core.common.components.MapStore
import com.ortega.tshombo.feature.myStore.domain.entity.StoreEntity
import com.ortega.tshombo.feature.myStore.presentation.viewModel.MyStoreViewModel

@Composable
fun BodySection(
    paddingValues: PaddingValues,
    myStoreViewModel: MyStoreViewModel,
    storeEntity: StoreEntity
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        InfoStore(storeEntity = storeEntity)

        Spacer(modifier = Modifier.height(16.dp))
        MapStore(locationEntity = storeEntity.location)
    }

}