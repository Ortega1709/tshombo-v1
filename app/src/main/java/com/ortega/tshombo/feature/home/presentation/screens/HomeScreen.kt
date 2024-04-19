package com.ortega.tshombo.feature.home.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.PersonOff
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.AutoSlidingCarousel
import com.ortega.tshombo.core.common.components.Loading
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.feature.auth.presentation.viewModel.AuthViewModel
import com.ortega.tshombo.core.common.components.ErrorFound
import com.ortega.tshombo.feature.home.presentation.components.PhonesNewsSection
import com.ortega.tshombo.feature.home.presentation.components.PhonesSection
import com.ortega.tshombo.feature.home.presentation.components.PromotionSection
import com.ortega.tshombo.feature.home.presentation.components.SeeMoreSection
import com.ortega.tshombo.feature.home.presentation.components.StoresSection
import com.ortega.tshombo.feature.home.presentation.viewModel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    authViewModel: AuthViewModel = hiltViewModel(),
    onClickNotification: () -> Unit,
    onClickLogout: () -> Unit,
) {

    val phonesUiState by homeViewModel.phonesUiState
    val phonesNewsUiState by homeViewModel.phonesNewsUiState
    val storesUiState by homeViewModel.storesUiState
    val globalLoading by homeViewModel.globalLoading

    val pullRefreshState = rememberPullRefreshState(globalLoading, { homeViewModel.fetchAll() })
    val images = listOf<String>("https://images.samsung.com/sg/smartphones/galaxy-s22/buy/S22_S22plus_Carousel_GroupKV_MO.jpg", "https://topsuccess.ng/public/uploads/all/9efSiFDIhj5QRcZruessyy7aigKbHYrpeiXHzMpC.png", "https://i.ytimg.com/vi/iy-8RtEpLIo/maxresdefault.jpg")

    Box(
        modifier = Modifier
            .pullRefresh(pullRefreshState)
    ) {

        Scaffold(
            topBar = {
                LargeTopAppBar(
                    actions = {
                        IconButton(onClick = onClickNotification) {
                            Icon(
                                imageVector = Icons.Rounded.Notifications,
                                contentDescription = null
                            )
                        }
                    },
                    title = {
                        MText(
                            modifier = Modifier.padding(end = 16.dp),
                            text = stringResource(R.string.find_right_phone),
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                authViewModel.logout {
                                    onClickLogout()
                                }
                            },
                        ) {
                            Icon(imageVector = Icons.Rounded.PersonOff, contentDescription = null)
                        }
                    }
                )
            }
        ) {
            if (globalLoading) Loading(paddingValues = it)
            else {
                if (phonesUiState.phones == null && storesUiState.stores == null && phonesNewsUiState.phones == null) {
                    ErrorFound(onClickRetry = { homeViewModel.fetchAll() }, paddingValues = it)
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(paddingValues = it)
                    ) {
                        //PromotionSection(images = listOf())
                        AutoSlidingCarousel(
                            itemsCount = images.size,
                            itemContent = { image ->
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(images[image])
                                        .crossfade(true)
                                        .build(),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .height(200.dp)
                                        .padding(horizontal = 16.dp)
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            },
                        )

                        SeeMoreSection(
                            text = stringResource(R.string.recommanded),
                            onClickMore = {})

                        PhonesSection(phonesUiState = phonesUiState)

//                        SeeMoreSection(text = stringResource(R.string.news), onClickMore = {})
//
//                        PhonesNewsSection(phonesNewsUiState = phonesNewsUiState)

                        SeeMoreSection(text = stringResource(R.string.stores), onClickMore = {})

                        StoresSection(storesUiState = storesUiState)

                        Spacer(modifier = Modifier.height(64.dp))
                    }
                }
            }
        }

        PullRefreshIndicator(
            modifier = Modifier.align(Alignment.TopCenter),
            refreshing = globalLoading,
            state = pullRefreshState
        )

    }


}