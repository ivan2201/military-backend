package com.military.backend.controller

import com.military.backend.domain.CertificateModel
import com.military.backend.service.CertificateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CertificateAPIController {

    @Autowired
    var certificateService: CertificateService? = null

    @GetMapping("api/certificates/")
    fun getCertificates():
            Set<CertificateModel> {
        return certificateService!!.getAll()
    }

    @GetMapping("api/certificate/{id}")
    fun getCertificate(@PathVariable certificateId: Int): CertificateModel {
        return certificateService!!.get(certificateId)
    }

    @PostMapping("api/certificate/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createCertificate(@RequestBody certificate: CertificateModel):
            CertificateModel {
        return certificateService!!.add(certificate)
    }

    @PostMapping("api/certificate/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateCertificate(@RequestBody certificate: CertificateModel):
            CertificateModel {
        return certificateService!!.edit(certificate)
    }

    @PostMapping("api/certificate/{id}/delete")
    fun deleteCertificateById(@RequestParam certificateId: Int)
    {
        certificateService!!.deleteById(certificateId)
    }

    @PostMapping("api/certificate/delete", consumes = ["application/json"],
        produces = ["application/json"])
    fun deleteCertificate(@RequestBody certificate: CertificateModel)
    {
        certificateService!!.delete(certificate)
    }
}
