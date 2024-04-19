package com.ortega.tshombo.feature.myStore.presentation.components

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.AddPhoneActivity
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.MapStore
import com.ortega.tshombo.core.common.components.PhoneLandScapeCard
import com.ortega.tshombo.feature.myStore.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.myStore.domain.entity.StoreEntity
import com.ortega.tshombo.feature.myStore.presentation.viewModel.MyStoreViewModel
import kotlin.math.log

@Composable
fun BodySection(
    paddingValues: PaddingValues,
    myStoreViewModel: MyStoreViewModel,
    storeEntity: StoreEntity,
    phones: List<PhoneEntity>?
) {

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 16.dp)
    ) {

        item {
            Spacer(modifier = Modifier.height(16.dp))
            InfoStore(storeEntity = storeEntity)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            MapStore(locationEntity = storeEntity.location)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            MText(text = stringResource(R.string.my_phones))
        }

        if (phones != null) {
            item { Spacer(modifier = Modifier.height(16.dp)) }
            items(phones.size) {
                PhoneLandScapeCard(
                    phoneEntity = phones[it],
                    onUpdate = {
                        val intent = Intent(context, AddPhoneActivity::class.java)
                        intent.putExtra("storeId", storeEntity.storeId)
                        intent.putExtra("phoneId", phones[it].phoneId)
                        intent.putExtra("image", phones[it].image)
                        intent.putExtra("description", phones[it].description)
                        intent.putExtra("brand", phones[it].brand)
                        intent.putExtra("price", phones[it].price)

                        context.startActivity(intent)
                    },
                    onDelete = { phoneId -> myStoreViewModel.deletePhoneById(phoneId) })
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Spacer(modifier = Modifier.height(70.dp))
            }

        }
    }
}