package com.ortega.tshombo.feature.phone.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ortega.tshombo.core.common.components.MapStore
import com.ortega.tshombo.core.secret.AppSecret
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.feature.myStore.domain.entity.LocationEntity
import com.ortega.tshombo.feature.phone.domain.entity.PhoneEntity

@Composable
fun BodySection(paddingValues: PaddingValues, phone: PhoneEntity) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop,
            contentDescription = phone.brand,
            model = phone.image,
        )

        Spacer(modifier = Modifier.height(16.dp))
        InfoPhone(phone = phone, onClickStore = {})

        Spacer(modifier = Modifier.height(16.dp))
        MapStore(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            locationEntity = LocationEntity(
                locationId = phone.store.location.locationId,
                lon = phone.store.location.lon,
                lat = phone.store.location.lat
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}