package com.military.backend.controller

import com.military.backend.domain.dto.DocumentDTO
import com.military.backend.domain.dto.EditDocumentDTO
import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.NewDocumentDTO
import com.military.backend.service.InnerDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/inner-document")
class InnerDocumentAPIController {

    @Autowired
    var innerDocumentService: InnerDocumentService? = null

    @GetMapping("/by-inform-object")
    fun getInnerDocuments(@RequestBody informObjectId: IdDTO): ResponseEntity<Set<DocumentDTO>> {
        return ResponseEntity(
            innerDocumentService!!.getAllByInformatizationObjectId(informObjectId.id.toInt()),
            HttpStatus.OK
        )
    }

    @PostMapping("/create", consumes = ["application/json"], produces = ["application/json"])
    fun createInnerDocument(@RequestBody innerDocument: NewDocumentDTO): ResponseEntity<DocumentDTO> {
        return ResponseEntity(innerDocumentService!!.add(innerDocument), HttpStatus.OK)
    }

    @PostMapping("/update", consumes = ["application/json"], produces = ["application/json"])
    fun updateInnerDocument(@RequestBody innerDocument: EditDocumentDTO): ResponseEntity<DocumentDTO> {
        return ResponseEntity(innerDocumentService!!.edit(innerDocument), HttpStatus.OK)
    }

    @PostMapping("/delete", consumes = ["application/json"])
    fun deleteInnerDocumentById(@RequestBody innerDocumentId: IdDTO): ResponseEntity<HttpStatus> {
        innerDocumentService!!.deleteById(innerDocumentId.id.toInt())
        return ResponseEntity(HttpStatus.OK)
    }
}
