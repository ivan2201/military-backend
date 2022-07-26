package com.military.backend.controller

import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.NewWarCampDTO
import com.military.backend.domain.dto.WarCampDTO
import com.military.backend.service.MilitaryBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/war-camp")
class MilitaryBaseAPIController {

    @Autowired
    var militaryBaseService: MilitaryBaseService? = null

    @GetMapping("/all")
    fun getMilitaryBases(): ResponseEntity<Set<WarCampDTO>> {
        return ResponseEntity(militaryBaseService!!.getAll(), HttpStatus.OK)
    }

    @GetMapping("/by-id")
    fun getMilitaryBase(@RequestBody militaryBaseId: IdDTO): ResponseEntity<WarCampDTO> {
        return ResponseEntity(militaryBaseService!!.get(militaryBaseId.id.toInt()), HttpStatus.OK)
    }

    @PostMapping("/create", consumes = ["application/json"], produces = ["application/json"])
    fun createMilitaryBase(@RequestBody militaryBaseModel: NewWarCampDTO): ResponseEntity<WarCampDTO> {
        return ResponseEntity(militaryBaseService!!.add(militaryBaseModel), HttpStatus.CREATED)
    }

    @PostMapping("/update", consumes = ["application/json"], produces = ["application/json"])
    fun updateMilitaryBase(@RequestBody militaryBaseModel: WarCampDTO): ResponseEntity<WarCampDTO> {
        return ResponseEntity(militaryBaseService!!.edit(militaryBaseModel), HttpStatus.OK)
    }

    @PostMapping("/delete")
    fun deleteMilitaryBaseById(@RequestBody militaryBaseId: IdDTO): ResponseEntity<HttpStatus> {
        militaryBaseService!!.deleteById(militaryBaseId.id.toInt())
        return ResponseEntity(HttpStatus.OK)
    }
}
