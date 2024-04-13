package com.ortega.tshombo.feature.home.presentation.components

import androidx.compose.material3.ListItem
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText

@Composable
fun SeeMoreSection(text: String, onClickMore: () -> Unit) {
    ListItem(
        headlineContent = { MText(text = text) },
        trailingContent = {
            TextButton(onClick = onClickMore) {
                MText(
                    text = stringResource(
                        R.string.see_more
                    ),
                )
            }
        },
    )
}