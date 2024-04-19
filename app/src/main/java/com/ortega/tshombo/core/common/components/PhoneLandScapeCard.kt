package com.ortega.tshombo.core.common.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ortega.tshombo.feature.myStore.domain.entity.PhoneEntity

@Composable
fun PhoneLandScapeCard(phoneEntity: PhoneEntity, onUpdate: () -> Unit, onDelete: (Int) -> Unit) {

    Item(
        onClick = { /*TODO*/ },
        overlineContent = { /*TODO*/ },
        leadingContent = {
            AsyncImage(
                modifier = Modifier
                    .size(70.dp, 70.dp)
                    .clip(RoundedCornerShape(12.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(phoneEntity.image)
                    .crossfade(true)
                    .build(),
                contentDescription = phoneEntity.brand,
                contentScale = ContentScale.Crop
            )
        },
        headlineContent = {
            MText(
                text = phoneEntity.brand,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
        supportingContent = {
            MText(
                text = phoneEntity.price.toString() + " CDF",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
        onClickUpdate = { onUpdate() },
        onClickDelete = { onDelete(phoneEntity.phoneId) },
    )

}