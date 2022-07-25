package com.military.backend.controller

import com.military.backend.domain.SpecialInvestigationModel
import com.military.backend.domain.dto.IdDTO
import com.military.backend.service.SpecialInvestigationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SpecialInvestigationAPIController {

    @Autowired
    var specialInvestigationService: SpecialInvestigationService? = null

    @GetMapping("api/spec-investigations")
    fun getSpecialInvestigations():
            Set<SpecialInvestigationModel> {
        return specialInvestigationService!!.getAll()
    }

    @GetMapping("api/spec-investigation")
    fun getSpecialInvestigation(@RequestBody id: IdDTO): SpecialInvestigationModel {
        return specialInvestigationService!!.get(id.id.toInt())
    }

    @PostMapping("api/spec-investigation/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createSpecialInvestigation(@RequestBody specInvestigation: SpecialInvestigationModel):
            SpecialInvestigationModel {
        return specialInvestigationService!!.add(specInvestigation)
    }

    @PostMapping("api/spec-investigation/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateSpecialInvestigation(@RequestBody specInvestigation: SpecialInvestigationModel):
            SpecialInvestigationModel {
        return specialInvestigationService!!.edit(specInvestigation)
    }

    @PostMapping("api/spec-investigation/delete")
    fun deleteSpecialInvestigationById(@RequestBody specInvestigationId: IdDTO)
    {
        specialInvestigationService!!.deleteById(specInvestigationId.id.toInt())
    }
}
