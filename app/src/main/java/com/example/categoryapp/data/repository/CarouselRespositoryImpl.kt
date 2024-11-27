package com.example.categoryapp.data.repository

import com.example.categoryapp.data.model.CategoryType
import com.example.categoryapp.data.store.CategoryStore
import com.example.categoryapp.domain.respository.CategoryRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(private val dataStore: CategoryStore) :
    CategoryRepository {

    override suspend fun getCategoryImage() = flow {
        emit(dataStore.categoryList)
    }

    override suspend fun getCategoryList(categoryType: CategoryType) = flow {
        val response = when (categoryType) {
            CategoryType.HOUSE -> dataStore.houseSubItems
            CategoryType.BIRDS -> dataStore.birdSubItems
            CategoryType.VEHICLE -> dataStore.vehicleSubItems
            CategoryType.CLOTHES -> dataStore.clothingItems
            CategoryType.TREES -> dataStore.treeSubItems
        }
        emit(response)
    }

}