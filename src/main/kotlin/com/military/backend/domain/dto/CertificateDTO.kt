package com.military.backend.domain.dto

data class CertificateDTO(
    val id: Int,
    val numberCert: String?,
    val dateCreateCert: String?,
    val dateFinishCert: String?,
    val category: String?,
    val owner: String?
)
