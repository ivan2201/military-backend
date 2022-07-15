package com.military.backend.service

import com.military.backend.domain.CertificateModel

interface CertificateService {
    fun add(certificate: CertificateModel): CertificateModel
    fun edit(certificate: CertificateModel): CertificateModel
    fun get(id: Int): CertificateModel
    fun delete(certificate: CertificateModel)
    fun deleteById(certificateId: Int)
    fun getAll(): Set<CertificateModel>
}
