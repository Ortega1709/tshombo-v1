package com.ortega.tshombo.feature.promotion.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ortega.tshombo.core.common.components.Empty
import com.ortega.tshombo.core.common.components.Item
import com.ortega.tshombo.core.common.components.Loading
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.secret.AppSecret
import com.ortega.tshombo.feature.promotion.presentation.state.PromotionsUiState
import com.ortega.tshombo.feature.promotion.presentation.viewModel.PromotionViewModel
import kotlin.math.log

@Composable
fun BodySection(
    promotionsUiState: PromotionsUiState,
    paddingValues: PaddingValues,
    promotionViewModel: PromotionViewModel
) {

    val context = LocalContext.current

    if (promotionsUiState.loading) Loading(paddingValues = paddingValues)
    else {
        if (promotionsUiState.promotions.isEmpty()) Empty(paddingValues = paddingValues)
        else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                item { Spacer(modifier = Modifier.height(16.dp)) }
                items(promotionsUiState.promotions) {

                    Item(
                        overlineContent = { MText(text = it.store.name) },
                        leadingContent = {
                            AsyncImage(
                                modifier = Modifier
                                    .size(70.dp, 70.dp)
                                    .clip(RoundedCornerShape(12.dp)),
                                model = it.image,
                                contentDescription = it.name,
                                contentScale = ContentScale.Crop
                            )
                        },
                        headlineContent = {
                            MText(
                                text = it.name,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        },
                        supportingContent = {
                            MText(
                                text = it.description,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        },
                        onClickDelete = { promotionViewModel.deletePromotionById(promotionId = it.promotionId) },
                        onClickUpdate = null,
                        onClick = {

                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    Spacer(modifier = Modifier.height(70.dp))
                }
            }
        }
    }
}
