package com.military.backend.controller

import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.SpecialInvestigationDTO
import com.military.backend.service.SpecialInvestigationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/spec-investigation")
class SpecialInvestigationAPIController {

    @Autowired
    var specialInvestigationService: SpecialInvestigationService? = null

    @PostMapping("/create", consumes = ["application/json"])
    fun createSpecialInvestigation(
        @RequestBody specInvestigation: SpecialInvestigationDTO
    ): ResponseEntity<HttpStatus> {
        specialInvestigationService!!.addOrEdit(specInvestigation)
        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping("/delete", consumes = ["application/json"])
    fun deleteSpecialInvestigationById(
        @RequestBody specInvestigationId: IdDTO
    ): ResponseEntity<HttpStatus> {
        specialInvestigationService!!.deleteById(specInvestigationId.id.toInt())
        return ResponseEntity(HttpStatus.OK)
    }
}
