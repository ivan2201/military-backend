package com.military.backend.controller

import com.military.backend.domain.dto.CertificateDTO
import com.military.backend.domain.dto.IdDTO
import com.military.backend.service.CertificateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/certificate")
class CertificateAPIController {

    @Autowired
    var certificateService: CertificateService? = null

    @PostMapping("/create", consumes = ["application/json"])
    fun createCertificate(@RequestBody certificate: CertificateDTO): ResponseEntity<HttpStatus> {
        certificateService!!.addOrEdit(certificate)
        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping("/delete", consumes = ["application/json"])
    fun deleteCertificateById(@RequestBody certificateId: IdDTO): ResponseEntity<HttpStatus> {
        certificateService!!.deleteById(certificateId.id.toInt())
        return ResponseEntity(HttpStatus.OK)
    }
}
