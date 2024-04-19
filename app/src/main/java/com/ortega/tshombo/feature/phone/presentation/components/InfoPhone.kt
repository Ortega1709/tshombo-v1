package com.ortega.tshombo.feature.phone.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Store
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.core.common.components.Container
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.feature.phone.domain.entity.PhoneEntity

@Composable
fun InfoPhone(phone: PhoneEntity, onClickStore: (Int) -> Unit) {
    Container (modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))  {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    MText(text = phone.brand, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(2.dp))
                    MText(text = phone.price.toString() + " CDF", fontWeight = FontWeight.SemiBold)
                }
                IconButton(onClick = { onClickStore(phone.store.storeId) }) {
                    Icon(imageVector = Icons.Rounded.Store, contentDescription = null)
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            MText(
                modifier = Modifier.fillMaxWidth(),
                color = DarkGray,
                text = phone.description
            )

        }
    }
}