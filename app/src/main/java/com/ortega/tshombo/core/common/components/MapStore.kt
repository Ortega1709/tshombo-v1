package com.ortega.tshombo.core.common.components

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.ktx.addMarker
import com.google.maps.android.ktx.awaitMap
import com.ortega.tshombo.MapActivity
import com.ortega.tshombo.R
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.core.theme.White
import kotlinx.coroutines.launch

@Composable
fun MapStore(
    modifier: Modifier = Modifier,
    locationEntity: com.ortega.tshombo.feature.myStore.domain.entity.LocationEntity
) {

    val context = LocalContext.current

    Container(modifier = modifier) {
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
            MapViewContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                storeLocation = LatLng(locationEntity.lat, locationEntity.lon)
            )
        }
    }
}

@Composable
private fun MapViewContainer(
    modifier: Modifier = Modifier,
    storeLocation: LatLng
) {

    val location = LatLng(storeLocation.latitude, storeLocation.longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 5f)
    }

    val properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.HYBRID))
    }

    GoogleMap(
        modifier = modifier
            .fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = properties,
    ) {
        Marker(
            state = MarkerState(position = location),
            title = stringResource(R.string.store)
        )
    }


}