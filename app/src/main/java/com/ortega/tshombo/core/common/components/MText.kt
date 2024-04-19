package com.ortega.tshombo.core.common.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.ortega.tshombo.core.theme.fontFamily

@Composable
fun MText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null,
    fontStyle: FontStyle? = null,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight = FontWeight.Medium,
    overflow: TextOverflow = TextOverflow.Visible,
    maxLines: Int = 100
) {
    Text(
        color = color,
        modifier = modifier,
        fontSize = fontSize,
        text = text,
        fontStyle = fontStyle,
        textAlign = textAlign,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        overflow = overflow,
        maxLines = maxLines
    )
}