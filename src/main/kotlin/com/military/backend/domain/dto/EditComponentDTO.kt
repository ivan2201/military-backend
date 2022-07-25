package com.military.backend.domain.dto

data class EditComponentDTO(
    val id: Int,
    val name: String?,
    val series: String?,
    val oiId: Int?
)
