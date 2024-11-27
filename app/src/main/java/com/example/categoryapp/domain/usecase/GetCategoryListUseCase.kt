package com.example.categoryapp.domain.usecase

import com.example.categoryapp.data.model.CategoryList
import com.example.categoryapp.domain.model.CategoryListRequest
import com.example.categoryapp.domain.respository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCategoryListUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {

    suspend fun getCategoryList(categoryListRequest: CategoryListRequest): Flow<List<CategoryList>> {
        return categoryRepository.getCategoryList(categoryListRequest.categoryType)
            .map { responseList ->
                responseList.filter { item ->
                    item.title.contains(categoryListRequest.searchQuery, ignoreCase = true)
                }
            }
    }
}