package com.military.backend.controller

import com.military.backend.domain.InnerDocumentModel
import com.military.backend.service.InnerDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class InnerDocumentAPIController {

    @Autowired
    var innerDocumentService: InnerDocumentService? = null

    @GetMapping("api/inner-documents/")
    fun getInnerDocuments(@RequestParam("inform_obj_id") informObjectId: Int?):
            Set<InnerDocumentModel> {
        return innerDocumentService!!.getAllByInformatizationObjectId(informObjectId)
    }

    @GetMapping("api/inner-document/{id}")
    fun getInnerDocument(@PathVariable innerDocumentId: Int): InnerDocumentModel {
        return innerDocumentService!!.get(innerDocumentId)
    }

    @PostMapping("api/inner-document/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createInnerDocument(@RequestBody innerDocument: InnerDocumentModel): InnerDocumentModel {
        return innerDocumentService!!.add(innerDocument)
    }

    @PostMapping("api/inner-document/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateInnerDocument(@RequestBody innerDocument: InnerDocumentModel): InnerDocumentModel {
        return innerDocumentService!!.edit(innerDocument)
    }

    @PostMapping("api/inner-document/{id}/delete")
    fun deleteInnerDocumentById(@RequestParam innerDocumentId: Int)
    {
        innerDocumentService!!.deleteById(innerDocumentId)
    }

    @PostMapping("api/inner-document/delete", consumes = ["application/json"],
        produces = ["application/json"])
    fun deleteInnerDocument(@RequestBody innerDocument: InnerDocumentModel)
    {
        innerDocumentService!!.delete(innerDocument)
    }
}
