package com.ortega.tshombo.feature.myStore.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.core.theme.White
import com.ortega.tshombo.feature.myStore.domain.entity.StoreEntity

@Composable
fun InfoStore(storeEntity: StoreEntity) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp)),
        color = White
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            MText(
                modifier = Modifier.fillMaxWidth(),
                text = storeEntity.name,
                fontWeight = FontWeight.SemiBold,
            )

            Spacer(modifier = Modifier.height(2.dp))
            MText(
                modifier = Modifier.fillMaxWidth(),
                color = DarkGray,
                text = "${storeEntity.city} ${storeEntity.commune} ${storeEntity.avenue}"
            )

            Spacer(modifier = Modifier.height(4.dp))
        }

    }
}