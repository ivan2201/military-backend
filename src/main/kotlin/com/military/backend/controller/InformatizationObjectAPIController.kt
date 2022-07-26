package com.military.backend.controller

import com.military.backend.domain.dto.EditObjectInformatizationDTO
import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.NewObjectInformatizationDTO
import com.military.backend.domain.dto.ObjectInformatizationDTO
import com.military.backend.service.ObjectInformatizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/informatization-object")
class InformatizationObjectAPIController {

    @Autowired
    var objectInformatizationService: ObjectInformatizationService? = null

    @PostMapping("/by-war-camp", consumes = ["application/json"], produces = ["application/json"])
    fun getInformatizationObjectsByMilBaseID(
        @RequestBody militaryBaseId: IdDTO
    ): ResponseEntity<Set<ObjectInformatizationDTO>> {
        return ResponseEntity(
            objectInformatizationService!!.getAllByMilitaryBaseId(militaryBaseId.id.toInt()),
            HttpStatus.OK
        )
    }

    @PostMapping("/by-id", produces = [APPLICATION_JSON_VALUE])
    fun getObjectInformatization(@RequestBody idDTO: IdDTO): ResponseEntity<ObjectInformatizationDTO> {
        return ResponseEntity(
            objectInformatizationService!!.get(idDTO.id.toInt()),
            HttpStatus.OK
        )
    }

    @PostMapping("/create", consumes = ["application/json"], produces = ["application/json"])
    fun createObjectInformatization(
        @RequestBody objectInformatization: NewObjectInformatizationDTO
    ): ResponseEntity<ObjectInformatizationDTO> {
        return ResponseEntity(
            objectInformatizationService!!.add(objectInformatization),
            HttpStatus.CREATED
        )
    }

    @PostMapping("/update", consumes = ["application/json"], produces = ["application/json"])
    fun updateObjectInformatization(
        @RequestBody objectInformatization: EditObjectInformatizationDTO
    ): ResponseEntity<ObjectInformatizationDTO> {
        return ResponseEntity(
            objectInformatizationService!!.edit(objectInformatization),
            HttpStatus.OK
        )
    }

    @PostMapping("/delete", consumes = ["application/json"])
    fun deleteObjectInformatizationById(
        @RequestBody objectInformatizationId: IdDTO
    ): ResponseEntity<HttpStatus> {
        objectInformatizationService!!.deleteById(objectInformatizationId.id.toInt())
        return ResponseEntity(HttpStatus.OK)
    }
}
