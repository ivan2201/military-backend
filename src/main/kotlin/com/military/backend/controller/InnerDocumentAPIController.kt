package com.military.backend.controller

import com.military.backend.domain.InnerDocumentModel
import com.military.backend.service.InnerDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class InnerDocumentAPIController {

    @Autowired
    lateinit var innerDocumentService: InnerDocumentService

    @GetMapping("api/inner-documents/")
    fun getInnerDocuments(@RequestParam("inform_obj_id") informObjectId: Int?):
            Set<InnerDocumentModel> {
        return innerDocumentService.getAllByInformatizationObjectId(informObjectId)
    }

}
