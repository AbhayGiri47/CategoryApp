package com.example.categoryapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.categoryapp.R
import com.example.categoryapp.data.model.CategoryList
import com.example.categoryapp.presentation.theme.listItemBgColor

@Composable
fun CategoryListItem(modifier: Modifier = Modifier, data: CategoryList) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_12)))
            .background(listItemBgColor)
            .padding(
                dimensionResource(id = R.dimen.dp_5)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.dp_55))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_10))),
            painter = painterResource(id = data.categoryImage),
            contentScale = ContentScale.Crop,
            contentDescription = data.title
        )
        Column(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.dp_10))) {
            Text(text = data.title, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(
                text = data.description,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                letterSpacing = 0.sp,
                lineHeight = 14.sp
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CategoryListItem(
        modifier = Modifier.fillMaxWidth(),
        data = CategoryList(
            categoryImage = R.drawable.ic_launcher_background,
            title = "Title",
            description = "Some Subtitle message"
        )
    )
}
