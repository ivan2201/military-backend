package com.military.backend.controller

import com.military.backend.domain.dto.IdDTO
import com.military.backend.service.ExcelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/download")
class ExcelController: RestApiController {

    @Autowired
    private val excelService: ExcelService? = null

    @PostMapping("/full")
    fun downloadFullExcel(): ResponseEntity<ByteArray> {
        val (name, resource) = excelService!!.generateFullExcel()

        return ResponseEntity
            .ok()
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$name")
            .contentLength(resource.size.toLong())
            .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
            .body(resource)
    }

    @PostMapping("/base")
    fun downloadMilitaryBaseExcel(@RequestBody idDTO: IdDTO): ResponseEntity<ByteArray> {
        val (name, resource) = excelService!!.generateMilitaryBaseExcel(idDTO)

        return ResponseEntity
            .ok()
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$name")
            .contentLength(resource.size.toLong())
            .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
            .body(resource)
    }

    @PostMapping("/obj")
    fun downloadObjInformExcel(@RequestBody idDTO: IdDTO): ResponseEntity<ByteArray> {
        val (name, resource) = excelService!!.generateObjInformExcel(idDTO)

        return ResponseEntity
            .ok()
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$name")
            .contentLength(resource.size.toLong())
            .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
            .body(resource)
    }
}