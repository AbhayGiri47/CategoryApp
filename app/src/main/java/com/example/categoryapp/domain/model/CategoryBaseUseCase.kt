package com.example.categoryapp.domain.model

import com.example.categoryapp.domain.usecase.GetCategoryAnalysisUseCase
import com.example.categoryapp.domain.usecase.GetCategoryImageUseCase
import com.example.categoryapp.domain.usecase.GetCategoryListUseCase

data class CategoryBaseUseCase(
    val getCategoryImageUseCase: GetCategoryImageUseCase,
    val getCategoryListUseCase: GetCategoryListUseCase,
    val getCategoryAnalysisUseCase: GetCategoryAnalysisUseCase
)