package com.ortega.tshombo.feature.myStore.presentation.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ortega.tshombo.MainActivity
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.MTextButton
import com.ortega.tshombo.core.common.components.MTextField
import com.ortega.tshombo.core.common.components.NavigationIconButton
import com.ortega.tshombo.core.theme.Blue
import com.ortega.tshombo.core.theme.LightGray
import com.ortega.tshombo.feature.myStore.domain.request.PhoneRequest
import com.ortega.tshombo.feature.myStore.presentation.viewModel.MyStoreViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPhoneScreen(
    myStoreViewModel: MyStoreViewModel = hiltViewModel(),
    storeId: Int,
    onClickBack: () -> Unit
) {

    val context = LocalContext.current

    val brandField = remember { mutableStateOf("") }
    val descriptionField = remember { mutableStateOf("") }
    val imageField = remember { mutableStateOf<Uri?>(null) }
    val priceField = remember { mutableStateOf("") }
    val loading = remember { mutableStateOf(false) }

    val stroke = Stroke(
        width = 3f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )

    val pickImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> imageField.value = uri }
    )

    Scaffold(
        topBar = {
            MediumTopAppBar(
                navigationIcon = { NavigationIconButton { onClickBack() } },
                title = {
                    MText(
                        text = stringResource(R.string.add_promotion),
                        fontWeight = FontWeight.Bold,
                    )
                },
                actions = {
                    MTextButton(
                        text = stringResource(id = R.string.add),
                        loading = loading.value,
                        onClick = {
                            if (brandField.value.isNotEmpty() && descriptionField.value.isNotEmpty() && imageField.value != null && priceField.value.isNotEmpty()) {
                                val phoneRequest = PhoneRequest(
                                    brand = brandField.value,
                                    description = descriptionField.value,
                                    price = priceField.value.toDouble()
                                )

                                myStoreViewModel.addPhone(
                                    context = context,
                                    uri = imageField.value!!,
                                    storeId = storeId,
                                    phoneRequest = phoneRequest,
                                    loading = { loading.value = it },
                                    onSuccess = {
                                        val intent = Intent(context, MainActivity::class.java)
                                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                                                Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        context.startActivity(intent)
                                    },
                                    onError = {
                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        },
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .drawBehind {
                        drawRoundRect(
                            color = Blue,
                            style = stroke,
                            cornerRadius = CornerRadius(5f, 5f)
                        )
                    }
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {
                        pickImage.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    },
            ) {

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    color = LightGray
                ) {
                    if (imageField.value == null) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(imageVector = Icons.Rounded.Image, contentDescription = null)
                        }
                    } else {
                        AsyncImage(
                            modifier = Modifier.fillMaxSize(),
                            model = imageField.value,
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                }
            }

            MTextField(
                label = stringResource(R.string.brand),
                value = brandField.value,
                onValueChange = { brandField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.description),
                value = descriptionField.value,
                singleLine = false,
                onValueChange = { descriptionField.value = it },
            )
            Spacer(modifier = Modifier.height(16.dp))

            MTextField(
                label = stringResource(R.string.price),
                value = priceField.value,
                onValueChange = { priceField.value = it },
            )
        }
    }

}