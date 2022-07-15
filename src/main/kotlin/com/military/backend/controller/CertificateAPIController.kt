package com.military.backend.controller

import com.military.backend.domain.CertificateModel
import com.military.backend.service.CertificateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CertificateAPIController {

    @Autowired
    lateinit var certificateService: CertificateService

    @GetMapping("api/certificates/")
    fun getCertificates():
            List<CertificateModel> {
        return certificateService.getAll()
    }

}
