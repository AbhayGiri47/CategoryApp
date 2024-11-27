package com.example.categoryapp.presentation.home

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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
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

    private val _categoryList = MutableStateFlow<List<CategoryList>>(emptyList())
    val categoryList get() = _categoryList.asStateFlow()

    private val _categoryAnalysis =
        MutableStateFlow<Resource<CategoryAnalysis>>(Resource.loading())
    val categoryAnalysis get() = _categoryAnalysis.asStateFlow()

    private val _showBottomSheet = MutableStateFlow(false)
    val showBottomSheet get() = _showBottomSheet.asStateFlow()

    private val _categoryListLoading = MutableStateFlow(true)
     val categoryListLoading get() = _categoryListLoading.asStateFlow()


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

    fun onSearchTriggered() {
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
        val categoryType = categoryImage.value[currentCategoryForDisplay].type

        categoryBaseUseCase.getCategoryListUseCase.getCategoryList(
            CategoryListRequest(
                categoryType,
                searchQuery.value
            )
        ).onStart {
            _categoryListLoading.emit(true)
        }.collect {
            _categoryListLoading.emit(false)
            _categoryList.emit(it)
        }
    }

    fun showBottomSheet() = viewModelScope.launch(dispatcher.io) {
        _showBottomSheet.emit(true)
        startCategoryAnalysis()
    }

    fun hideBottomSheet() = viewModelScope.launch(dispatcher.io) {
        _showBottomSheet.emit(false)
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