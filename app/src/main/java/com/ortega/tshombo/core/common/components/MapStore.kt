package com.ortega.tshombo.core.common.components

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Fullscreen
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.ortega.tshombo.MapActivity
import com.ortega.tshombo.R
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.core.theme.White

@Composable
fun MapStore(locationEntity: com.ortega.tshombo.feature.myStore.domain.entity.LocationEntity) {

    val context = LocalContext.current


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)), color = White
    ) {
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
                MText(
                    text = stringResource(R.string.location),
                    fontWeight = FontWeight.SemiBold
                )
                IconButton(onClick = {
                    val intent = Intent(context, MapActivity::class.java)
                    intent.putExtra("lat", locationEntity.lat)
                    intent.putExtra("lon", locationEntity.lon)

                    context.startActivity(intent)
                }) {
                    Icon(
                        imageVector = Icons.Rounded.Fullscreen,
                        contentDescription = null,
                        tint = DarkGray
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                color = DarkGray
            ) {
            }
        }
    }

}