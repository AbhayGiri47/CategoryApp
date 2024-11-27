package com.example.categoryapp.domain.model

import com.example.categoryapp.data.model.CategoryList
import com.example.categoryapp.data.model.CategoryType

data class CategoryAnalysisRequest(
    val categoryList: List<CategoryList>?,
    val analysisOutputCount: Int = 3,
    val categoryType: CategoryType
)
