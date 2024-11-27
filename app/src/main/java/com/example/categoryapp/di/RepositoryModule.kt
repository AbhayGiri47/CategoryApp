package com.example.categoryapp.di

import com.example.categoryapp.data.repository.CategoryRepositoryImpl
import com.example.categoryapp.domain.respository.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideCategoryRepository(categoryRepository: CategoryRepositoryImpl): CategoryRepository
}
