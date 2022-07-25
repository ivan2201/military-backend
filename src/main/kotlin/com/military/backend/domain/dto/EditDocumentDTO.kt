package com.military.backend.domain.dto

data class EditDocumentDTO(
    val id: Int,
    val name: String?,
    val regNum: String?,
    val date: String?,
    val oiId: Int?
)
