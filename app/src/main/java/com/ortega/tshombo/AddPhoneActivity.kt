package com.ortega.tshombo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ortega.tshombo.core.theme.TshomboTheme
import com.ortega.tshombo.feature.myStore.presentation.screens.AddPhoneScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPhoneActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val storeId = intent.getIntExtra("storeId", 0)
        val phoneId = intent.getIntExtra("phoneId", 0)
        val image = intent.getStringExtra("image")
        val brand = intent.getStringExtra("brand")
        val description = intent.getStringExtra("description")
        val price = intent.getDoubleExtra("price", 0.0)

        setContent {
            TshomboTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddPhoneScreen(
                        storeId = storeId,
                        image = image,
                        brand = brand,
                        description = description,
                        price = price,
                        phoneId = phoneId,
                        onClickBack = { finish() },
                    )
                }
            }
        }
    }
}
