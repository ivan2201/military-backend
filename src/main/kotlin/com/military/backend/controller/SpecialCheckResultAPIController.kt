package com.military.backend.controller

import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.SpecialCheckResultDTO
import com.military.backend.service.SpecialCheckResultService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/spec-check")
class SpecialCheckResultAPIController {

    @Autowired
    var specialCheckResultService: SpecialCheckResultService? = null

    @PostMapping("/create", consumes = ["application/json"])
    fun createSpecialCheckResult(@RequestBody specCheck: SpecialCheckResultDTO): ResponseEntity<HttpStatus> {
        specialCheckResultService!!.addOrEdit(specCheck)
        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping("/delete", consumes = ["application/json"])
    fun deleteSpecialCheckResultById(@RequestBody specCheckId: IdDTO): ResponseEntity<HttpStatus> {
        specialCheckResultService!!.deleteById(specCheckId.id.toInt())
        return ResponseEntity(HttpStatus.OK)
    }
}
