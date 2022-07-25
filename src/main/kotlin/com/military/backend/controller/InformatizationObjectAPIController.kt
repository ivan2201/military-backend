package com.military.backend.controller

import com.military.backend.domain.dto.ObjectInformatizationDTO
import com.military.backend.service.ObjectInformatizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class InformatizationObjectAPIController {

    @Autowired
    var objectInformatizationService: ObjectInformatizationService? = null

    @GetMapping("api/informatization-objects/")
    fun getInformatizationObjects(@RequestParam("mil_base_id") militaryBaseId: Int?):
            Set<ObjectInformatizationDTO> {
        return objectInformatizationService!!.getAllByMilitaryBaseId(militaryBaseId)
    }

    @GetMapping("api/informatization-object/{id}")
    fun getObjectInformatization(@PathVariable objectInformatizationId: Int): ObjectInformatizationDTO {
        return objectInformatizationService!!.get(objectInformatizationId)
    }

    @PostMapping("api/informatization-object/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createObjectInformatization(@RequestBody objectInformatization: ObjectInformatizationDTO):
            ObjectInformatizationDTO {
        return objectInformatizationService!!.add(objectInformatization)
    }

    @PostMapping("api/informatization-object/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateObjectInformatization(@RequestBody objectInformatization: ObjectInformatizationDTO):
            ObjectInformatizationDTO {
        return objectInformatizationService!!.edit(objectInformatization)
    }

    @PostMapping("api/informatization-object/{id}/delete")
    fun deleteObjectInformatizationById(@RequestParam objectInformatizationId: Int)
    {
        objectInformatizationService!!.deleteById(objectInformatizationId)
    }
}
