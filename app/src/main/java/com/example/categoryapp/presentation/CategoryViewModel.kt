package com.example.categoryapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.categoryapp.data.model.Category
import com.example.categoryapp.data.model.CategoryList
import com.example.categoryapp.domain.CoroutinesDispatcherProvider
import com.example.categoryapp.domain.model.CategoryAnalysis
import com.example.categoryapp.domain.model.CategoryAnalysisRequest
import com.example.categoryapp.domain.model.CategoryBaseUseCase
import com.example.categoryapp.domain.model.CategoryListRequest
import com.example.categoryapp.domain.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val dispatcher: CoroutinesDispatcherProvider,
    private val categoryBaseUseCase: CategoryBaseUseCase
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery get() = _searchQuery.asStateFlow()

    private val _categoryImage = MutableStateFlow<List<Category>>(emptyList())
    val categoryImage get() = _categoryImage.asStateFlow()

    private val _categoryList = MutableStateFlow<List<CategoryList>?>(null)
    val categoryList get() = _categoryList.asStateFlow()

    private val _categoryAnalysis =
        MutableStateFlow<Resource<CategoryAnalysis>>(Resource.loading())
    val categoryAnalysis get() = _categoryAnalysis.asStateFlow()

    private val _showBottomSheet = MutableSharedFlow<Boolean>()
    val showBottomSheet get() = _showBottomSheet.asSharedFlow()

    private var currentCategoryForDisplay = -1

    init {
        getCategoryImage()
    }

    fun onCategoryChanged(index: Int) {
        currentCategoryForDisplay = index
        _searchQuery.value = ""
        getCategoryList()
    }

    fun onSearchValueChange(query: String) {
        _searchQuery.value = query
        onSearchTriggered()
    }

    private fun onSearchTriggered() {
        getCategoryList()
    }

    private fun getCategoryImage() = viewModelScope.launch(dispatcher.io) {
        categoryBaseUseCase.getCategoryImageUseCase.getCategoryImage().collect {
            _categoryImage.emit(it)
        }
    }

    private fun getCategoryList() = viewModelScope.launch(dispatcher.io) {
        if (currentCategoryForDisplay < 0 || categoryImage.value.isEmpty()) {
            return@launch
        }
        val catalogType = categoryImage.value[currentCategoryForDisplay].type
        categoryBaseUseCase.getCategoryListUseCase.getCategoryList(
            CategoryListRequest(
                catalogType,
                searchQuery.value
            )
        ).collect {
            _categoryList.emit(it)
        }
    }

    fun showBottomSheet() = viewModelScope.launch(dispatcher.io) {
        _showBottomSheet.emit(true)
        startCategoryAnalysis()
    }

    private fun startCategoryAnalysis() = viewModelScope.launch(dispatcher.computation) {
        _categoryAnalysis.emit(Resource.loading())
        categoryBaseUseCase.getCategoryAnalysisUseCase.getCategoryAnalysisData(
            CategoryAnalysisRequest(
                categoryList.value,
                categoryType = categoryImage.value[currentCategoryForDisplay].type
            )
        ).catch {
            _categoryAnalysis.emit(Resource.error(it))
        }.collect {
            _categoryAnalysis.emit(Resource.success(it))
        }
    }
}