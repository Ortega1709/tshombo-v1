package com.ortega.tshombo.feature.search.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ortega.tshombo.R
import com.ortega.tshombo.core.common.components.MText
import com.ortega.tshombo.core.common.components.NavigationIconButton
import com.ortega.tshombo.core.theme.Blue
import com.ortega.tshombo.core.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(onClickBack: () -> Unit) {
    Scaffold(
        topBar = {
            SearchBar(
                colors = SearchBarDefaults.colors(
                    containerColor = White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp)
                    .padding(16.dp),
                leadingIcon = {
                    NavigationIconButton(onClick = onClickBack)
                },
                placeholder = {
                    MText(text = stringResource(id = R.string.search))
                },
                query = "",
                onQueryChange = {},
                onSearch = {},
                active = false,
                onActiveChange = {},
            ) {

            }
        }
    ) {

    }
}