package com.military.backend.service.impl

import com.military.backend.domain.CertificateModel
import com.military.backend.repository.CertificateRepository
import com.military.backend.service.CertificateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CertificateServiceImpl: CertificateService {
    @Autowired
    var certificateRepository: CertificateRepository? = null

    override fun add(certificate: CertificateModel): CertificateModel
    {
        if (certificate.id == null || certificate.id == -1)
            return certificateRepository!!.save(certificate)
        else
            throw Exception("Bad value")
    }

    override fun edit(certificate: CertificateModel): CertificateModel
    {
        if (certificate.id != null && certificate.id > 0)
            return certificateRepository!!.save(certificate)
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): CertificateModel
    {
        return certificateRepository!!.getOne(id)
    }

    override fun delete(certificate: CertificateModel)
    {
        certificateRepository!!.delete(certificate)
    }

    override fun deleteById(certificateId: Int) {
        certificateRepository!!.deleteById(certificateId)
    }

    override fun getAll(): Set<CertificateModel> {
        return certificateRepository!!.findAll().toSet()
    }
}
