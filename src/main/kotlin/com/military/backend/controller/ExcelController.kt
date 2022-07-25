package com.military.backend.controller

import com.military.backend.domain.dto.MilitaryBaseExcelDTO
import com.military.backend.domain.dto.ObjectInformExcelDTO
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
@RequestMapping("/excel")
class ExcelController {

    @Autowired
    private val excelService: ExcelService? = null

    @PostMapping("/download/full")
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

    @PostMapping("/download/base")
    fun downloadMilitaryBaseExcel(@RequestBody militaryBaseExcelDTO: MilitaryBaseExcelDTO): ResponseEntity<ByteArray> {
        val (name, resource) = excelService!!.generateMilitaryBaseExcel(militaryBaseExcelDTO)

        return ResponseEntity
            .ok()
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$name")
            .contentLength(resource.size.toLong())
            .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
            .body(resource)
    }

    @PostMapping("/download/obj")
    fun downloadObjInformExcel(@RequestBody objectInformExcelDTO: ObjectInformExcelDTO): ResponseEntity<ByteArray> {
        val (name, resource) = excelService!!.generateObjInformExcel(objectInformExcelDTO)

        return ResponseEntity
            .ok()
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition")
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=$name")
            .contentLength(resource.size.toLong())
            .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
            .body(resource)
    }
}