package com.military.backend.controller

import com.military.backend.domain.dto.WarCampDTO
import com.military.backend.service.MilitaryBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MilitaryBaseAPIController {

    @Autowired
    var militaryBaseService: MilitaryBaseService? = null

    @GetMapping("api/military-bases/")
    fun getMilitaryBases(): Set<WarCampDTO> {
        return militaryBaseService!!.getAll()
    }

    @GetMapping("api/military-base/{id}")
    fun getMilitaryBase(@PathVariable militaryBaseId: Int): WarCampDTO {
        return militaryBaseService!!.get(militaryBaseId)
    }

    @PostMapping("api/military-base/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createMilitaryBase(@RequestBody militaryBaseModel: WarCampDTO): WarCampDTO {
        return militaryBaseService!!.add(militaryBaseModel)
    }

    @PostMapping("api/military-base/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateMilitaryBase(@RequestBody militaryBaseModel: WarCampDTO): WarCampDTO {
        return militaryBaseService!!.edit(militaryBaseModel)
    }

    @PostMapping("api/military-base/{id}/delete")
    fun deleteMilitaryBaseById(@RequestParam militaryBaseId: Int)
    {
        militaryBaseService!!.deleteById(militaryBaseId)
    }
}
