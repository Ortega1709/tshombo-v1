package com.ortega.tshombo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ortega.tshombo.core.theme.TshomboTheme
import com.ortega.tshombo.feature.phone.presentation.screens.PhoneScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhoneActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val phoneId = intent.getIntExtra("phoneId", 0)

        setContent {
            TshomboTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   PhoneScreen(phoneId = phoneId,  onClickBack = { finish() })
                }
            }
        }
    }
}
