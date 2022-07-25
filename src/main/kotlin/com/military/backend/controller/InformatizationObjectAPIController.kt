package com.military.backend.controller

import com.military.backend.domain.dto.EditObjectInformatizationDTO
import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.NewObjectInformatizationDTO
import com.military.backend.domain.dto.ObjectInformatizationDTO
import com.military.backend.service.ObjectInformatizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class InformatizationObjectAPIController {

    @Autowired
    var objectInformatizationService: ObjectInformatizationService? = null

    @GetMapping("api/informatization-objects/by-mil-base")
    fun getInformatizationObjectsByMilBaseID(@RequestBody militaryBaseId: IdDTO):
            Set<ObjectInformatizationDTO> {
        return objectInformatizationService!!.getAllByMilitaryBaseId(militaryBaseId.id.toInt())
    }

    @GetMapping("api/informatization-objects")
    fun getInformatizationObjects():
            Set<ObjectInformatizationDTO> {
        return objectInformatizationService!!.getAll()
    }

    @GetMapping("api/informatization-object")
    fun getObjectInformatization(@RequestBody objectInformatizationId: IdDTO): ObjectInformatizationDTO {
        return objectInformatizationService!!.get(objectInformatizationId.id.toInt())
    }

    @PostMapping("api/informatization-object/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createObjectInformatization(@RequestBody objectInformatization: NewObjectInformatizationDTO):
            ObjectInformatizationDTO {
        return objectInformatizationService!!.add(objectInformatization)
    }

    @PostMapping("api/informatization-object/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateObjectInformatization(@RequestBody objectInformatization: EditObjectInformatizationDTO):
            ObjectInformatizationDTO {
        return objectInformatizationService!!.edit(objectInformatization)
    }

    @PostMapping("api/informatization-object/delete")
    fun deleteObjectInformatizationById(@RequestBody objectInformatizationId: IdDTO)
    {
        objectInformatizationService!!.deleteById(objectInformatizationId.id.toInt())
    }
}
