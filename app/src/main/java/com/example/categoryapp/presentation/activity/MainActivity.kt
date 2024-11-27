package com.example.categoryapp.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.categoryapp.presentation.home.CategoryPage
import com.example.categoryapp.presentation.theme.CategoryAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategoryAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CategoryPage()
                }
            }
        }
    }
}
