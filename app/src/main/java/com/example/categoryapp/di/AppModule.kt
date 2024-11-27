package com.example.categoryapp.di

import com.example.categoryapp.data.store.CategoryStore
import com.example.categoryapp.domain.model.CategoryBaseUseCase
import com.example.categoryapp.domain.usecase.GetCategoryAnalysisUseCase
import com.example.categoryapp.domain.usecase.GetCategoryImageUseCase
import com.example.categoryapp.domain.usecase.GetCategoryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCategoryStore(): CategoryStore {
        return CategoryStore()
    }

    @Provides
    fun provideHomePageBaseUseCase(
        getCategoryImageUseCase: GetCategoryImageUseCase,
        getCategoryListUseCase: GetCategoryListUseCase,
        getCategoryAnalysisUseCase: GetCategoryAnalysisUseCase
    ): CategoryBaseUseCase {
        return CategoryBaseUseCase(
            getCategoryImageUseCase = getCategoryImageUseCase,
            getCategoryListUseCase = getCategoryListUseCase,
            getCategoryAnalysisUseCase = getCategoryAnalysisUseCase
        )
    }

    @Provides
    fun provideCategoryAnalysisUseCase(): GetCategoryAnalysisUseCase {
        return GetCategoryAnalysisUseCase()
    }
}