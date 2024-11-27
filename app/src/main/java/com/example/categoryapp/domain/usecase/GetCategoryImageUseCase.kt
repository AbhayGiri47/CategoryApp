package com.example.categoryapp.domain.usecase

import com.example.categoryapp.data.model.Category
import com.example.categoryapp.domain.respository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryImageUseCase @Inject constructor(private val categoryRepository: CategoryRepository)
{
    suspend fun getCategoryImage():Flow<List<Category>> {
        return categoryRepository.getCategoryImage()
    }
}