package com.military.backend.controller

import com.military.backend.domain.SpecialInvestigationModel
import com.military.backend.service.SpecialInvestigationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class SpecialInvestigationAPIController {

    @Autowired
    var specialInvestigationService: SpecialInvestigationService? = null

    @GetMapping("api/spec-investigations/")
    fun getSpecialInvestigations():
            Set<SpecialInvestigationModel> {
        return specialInvestigationService!!.getAll()
    }

    @GetMapping("api/spec-investigation/{id}")
    fun getSpecialInvestigation(@PathVariable specInvestigationId: Int): SpecialInvestigationModel {
        return specialInvestigationService!!.get(specInvestigationId)
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

    @PostMapping("api/spec-investigation/{id}/delete")
    fun deleteSpecialInvestigationById(@RequestParam specInvestigationId: Int)
    {
        specialInvestigationService!!.deleteById(specInvestigationId)
    }

    @PostMapping("api/spec-investigation/delete", consumes = ["application/json"],
        produces = ["application/json"])
    fun deleteSpecialInvestigation(@RequestBody specInvestigation: SpecialInvestigationModel)
    {
        specialInvestigationService!!.delete(specInvestigation)
    }
}
