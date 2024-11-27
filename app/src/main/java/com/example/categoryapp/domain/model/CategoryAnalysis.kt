package com.example.categoryapp.domain.model

data class CategoryAnalysis(
    val itemCount: Int,
    val characterOccurrences: Map<Char, Int>,
    val categoryType: String
)