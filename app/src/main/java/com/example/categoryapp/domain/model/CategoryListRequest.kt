package com.example.categoryapp.domain.model

import com.example.categoryapp.data.model.CategoryType

data class CategoryListRequest(val categoryType: CategoryType, val searchQuery: String)
