package com.military.backend.controller

import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.NewWarCampDTO
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

    @GetMapping("api/military-bases")
    fun getMilitaryBases(): Set<WarCampDTO> {
        return militaryBaseService!!.getAll()
    }

    @GetMapping("api/military-base")
    fun getMilitaryBase(@RequestBody militaryBaseId: IdDTO): WarCampDTO {
        return militaryBaseService!!.get(militaryBaseId.id.toInt())
    }

    @PostMapping("api/military-base/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createMilitaryBase(@RequestBody militaryBaseModel: NewWarCampDTO): WarCampDTO {
        return militaryBaseService!!.add(militaryBaseModel)
    }

    @PostMapping("api/military-base/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateMilitaryBase(@RequestBody militaryBaseModel: WarCampDTO): WarCampDTO {
        return militaryBaseService!!.edit(militaryBaseModel)
    }

    @PostMapping("api/military-base/delete")
    fun deleteMilitaryBaseById(@RequestBody militaryBaseId: IdDTO)
    {
        militaryBaseService!!.deleteById(militaryBaseId.id.toInt())
    }
}
