package com.example.categoryapp.domain.usecase

import com.example.categoryapp.domain.model.CategoryAnalysis
import com.example.categoryapp.domain.model.CategoryAnalysisRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCategoryAnalysisUseCase() {

    fun getCategoryAnalysisData(params: CategoryAnalysisRequest): Flow<CategoryAnalysis> = flow {
        requireNotNull(params.categoryList) { "Item list cannot be empty" }
        require(params.categoryList.isNotEmpty()) { "Item list cannot be empty" }

        val occurrence = hashMapOf<Char, Int>()
        for (item in params.categoryList) {
            for (data in item.title) {
                if (data == ' ') continue
                occurrence[data] = (occurrence[data] ?: 0) + 1
            }
        }
        val sortedMap =
            occurrence.toList().sortedByDescending { (_, value) -> value }
                .take(params.analysisOutputCount).toMap()
        emit(
            CategoryAnalysis(
                itemCount = params.categoryList.size,
                characterOccurrences = sortedMap,
                categoryType = params.categoryType.toString().lowercase()
                    .replaceFirstChar { it.uppercaseChar() }
            )
        )
    }
}