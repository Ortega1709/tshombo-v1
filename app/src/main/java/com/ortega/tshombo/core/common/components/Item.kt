package com.ortega.tshombo.core.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.core.theme.White

@Composable
fun Item(
    overlineContent: @Composable() (() -> Unit)?,
    leadingContent: @Composable() (() -> Unit)?,
    headlineContent: @Composable () -> Unit,
    supportingContent: @Composable() (() -> Unit)?,
    onClickUpdate: () -> Unit,
    onClickDelete: () -> Unit,
    iconSize: Dp = 30.dp
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = White
    ) {

        ListItem(
            overlineContent = overlineContent,
            leadingContent = leadingContent,
            headlineContent = headlineContent,
            supportingContent = supportingContent,
            colors = ListItemDefaults.colors(containerColor = White),
            trailingContent = {
                Row {
                    IconButton(
                        modifier = Modifier.size(iconSize),
                        onClick = onClickUpdate,
                        colors = mIconButtonColors()
                    ) {
                        Icon(imageVector = Icons.Rounded.Edit, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(
                        modifier = Modifier.size(iconSize),
                        onClick = onClickDelete,
                        colors = mIconButtonColors()
                    ) {
                        Icon(imageVector = Icons.Rounded.Delete, contentDescription = null)
                    }
                }

            }
        )

    }
}

