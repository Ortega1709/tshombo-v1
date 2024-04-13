package com.ortega.tshombo.feature.home.presentation.components

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.PhoneActivity
import com.ortega.tshombo.core.theme.DarkGray
import com.ortega.tshombo.feature.home.domain.entity.PhoneEntity
import com.ortega.tshombo.feature.home.domain.useCase.GetPhones


@Composable
fun PhoneCard(phones: PhoneEntity) {

    val context = LocalContext.current

    Column (
        modifier = Modifier
            .padding(end = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                val intent = Intent(context, PhoneActivity::class.java)
                context.startActivity(intent)
            }
    ) {
        Surface (
            modifier = Modifier
                .width(200.dp)
                .height(150.dp),
            shape = RoundedCornerShape(12.dp),
            color = DarkGray
        ) {

        }

        Spacer(modifier = Modifier.height(8.dp))

        Surface (
            modifier = Modifier
                .width(150.dp)
                .height(10.dp),
            shape = RoundedCornerShape(12.dp),
            color = DarkGray
        ) {

        }

        Spacer(modifier = Modifier.height(8.dp))

        Surface (
            modifier = Modifier
                .width(100.dp)
                .height(10.dp),
            shape = RoundedCornerShape(12.dp),
            color = DarkGray
        ) {

        }
    }
}

@Composable
fun PhoneCard() {

    val context = LocalContext.current

    Column (
        modifier = Modifier
            .padding(end = 12.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                val intent = Intent(context, PhoneActivity::class.java)
                context.startActivity(intent)
            }
    ) {
        Surface (
            modifier = Modifier
                .width(200.dp)
                .height(150.dp),
            shape = RoundedCornerShape(12.dp),
            color = DarkGray
        ) {

        }

        Spacer(modifier = Modifier.height(8.dp))

        Surface (
            modifier = Modifier
                .width(150.dp)
                .height(10.dp),
            shape = RoundedCornerShape(12.dp),
            color = DarkGray
        ) {

        }

        Spacer(modifier = Modifier.height(8.dp))

        Surface (
            modifier = Modifier
                .width(100.dp)
                .height(10.dp),
            shape = RoundedCornerShape(12.dp),
            color = DarkGray
        ) {

        }
    }
}