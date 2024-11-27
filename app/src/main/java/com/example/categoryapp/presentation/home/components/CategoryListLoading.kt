package com.example.categoryapp.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.categoryapp.R


@Composable
fun CategoryListLoading(
    modifier: Modifier = Modifier,
    message: String = stringResource(id = R.string.txt_loading)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = message)
    }
}

@Preview
@Composable
private fun Preview() {
    CategoryListLoading()
}