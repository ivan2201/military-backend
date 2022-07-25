package com.military.backend.controller

import com.military.backend.domain.dto.DocumentDTO
import com.military.backend.domain.dto.EditDocumentDTO
import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.NewDocumentDTO
import com.military.backend.service.InnerDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class InnerDocumentAPIController {

    @Autowired
    var innerDocumentService: InnerDocumentService? = null

    @GetMapping("api/inner-documents/by-inform-object")
    fun getInnerDocuments(@RequestBody informObjectId: IdDTO):
            Set<DocumentDTO> {
        return innerDocumentService!!.getAllByInformatizationObjectId(informObjectId.id.toInt())
    }

    @GetMapping("api/inner-document")
    fun getInnerDocument(@RequestBody innerDocumentId: IdDTO): DocumentDTO {
        return innerDocumentService!!.get(innerDocumentId.id.toInt())
    }

    @PostMapping("api/inner-document/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createInnerDocument(@RequestBody innerDocument: NewDocumentDTO): DocumentDTO {
        return innerDocumentService!!.add(innerDocument)
    }

    @PostMapping("api/inner-document/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateInnerDocument(@RequestBody innerDocument: EditDocumentDTO): DocumentDTO {
        return innerDocumentService!!.edit(innerDocument)
    }

    @PostMapping("api/inner-document/delete")
    fun deleteInnerDocumentById(@RequestBody innerDocumentId: IdDTO)
    {
        innerDocumentService!!.deleteById(innerDocumentId.id.toInt())
    }
}
