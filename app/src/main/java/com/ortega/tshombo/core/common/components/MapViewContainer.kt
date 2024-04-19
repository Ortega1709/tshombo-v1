package com.ortega.tshombo.core.common.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.launch

@Composable
private fun MapViewContainer(
    map: MapView,
    location: LatLng
) {
    val coroutineScope = rememberCoroutineScope()

    AndroidView({ map }) { mapView ->
        coroutineScope.launch {
            val googleMap = mapView.awaitMap()
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))
        }
    }
}