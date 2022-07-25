package com.military.backend.domain.dto

data class EditObjectInformatizationDTO(
    val id: Int,
    val name: String?,
    val certId: Int?,
    val siId: Int?,
    val scrId: Int?,
    val mbId: Int?
)
