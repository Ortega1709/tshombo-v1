package com.ortega.tshombo.feature.home.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.core.theme.DarkGray

@Composable
fun PromotionSection(images: List<Any>) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp)
            .padding(horizontal = 16.dp),
        color = DarkGray,
        shape = RoundedCornerShape(size = 12.dp)
    ) {

    }


//    LaunchedEffect(currentImageIndex) {
//        while (true) {
//            delay(5000L)
//            if (!isAnimating) {
//                val nextIndex = (currentImageIndex + 1) % images.size
//                currentImageIndex = nextIndex
//            }
//        }
//    }
}