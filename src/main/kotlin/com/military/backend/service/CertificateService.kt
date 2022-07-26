package com.military.backend.service

import com.military.backend.domain.CertificateModel
import com.military.backend.domain.dto.CertificateDTO
import com.military.backend.domain.dto.IdDTO

interface CertificateService {
    fun addOrEdit(certificateDTO: CertificateDTO)
    fun get(idDTO: IdDTO): CertificateModel
    fun deleteById(certificateId: Int)
    fun getAll(): Set<CertificateModel>
}
