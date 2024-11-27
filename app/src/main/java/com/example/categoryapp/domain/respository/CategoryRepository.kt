package com.example.categoryapp.domain.respository

import com.example.categoryapp.data.model.Category
import com.example.categoryapp.data.model.CategoryList
import com.example.categoryapp.data.model.CategoryType
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategoryImage(): Flow<List<Category>>
    suspend fun getCategoryList(categoryType: CategoryType): Flow<List<CategoryList>>
}