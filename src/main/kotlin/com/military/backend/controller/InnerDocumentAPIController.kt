package com.military.backend.controller

import com.military.backend.domain.dto.DocumentDTO
import com.military.backend.service.InnerDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class InnerDocumentAPIController {

    @Autowired
    var innerDocumentService: InnerDocumentService? = null

    @GetMapping("api/inner-documents/")
    fun getInnerDocuments(@RequestParam("inform_obj_id") informObjectId: Int?):
            Set<DocumentDTO> {
        return innerDocumentService!!.getAllByInformatizationObjectId(informObjectId)
    }

    @GetMapping("api/inner-document/{id}")
    fun getInnerDocument(@PathVariable innerDocumentId: Int): DocumentDTO {
        return innerDocumentService!!.get(innerDocumentId)
    }

    @PostMapping("api/inner-document/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createInnerDocument(@RequestBody innerDocument: DocumentDTO): DocumentDTO {
        return innerDocumentService!!.add(innerDocument)
    }

    @PostMapping("api/inner-document/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateInnerDocument(@RequestBody innerDocument: DocumentDTO): DocumentDTO {
        return innerDocumentService!!.edit(innerDocument)
    }

    @PostMapping("api/inner-document/{id}/delete")
    fun deleteInnerDocumentById(@RequestParam innerDocumentId: Int)
    {
        innerDocumentService!!.deleteById(innerDocumentId)
    }
}
