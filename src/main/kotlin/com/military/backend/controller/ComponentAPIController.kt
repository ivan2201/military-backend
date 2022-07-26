package com.military.backend.controller

import com.military.backend.domain.dto.ComponentDTO
import com.military.backend.domain.dto.EditComponentDTO
import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.NewComponentDTO
import com.military.backend.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/component")
class ComponentAPIController {

    @Autowired
    var componentService: ComponentService? = null

    @GetMapping("/by-inform-object", consumes = ["application/json"], produces = ["application/json"])
    fun getComponentsByMilitaryBaseId(@RequestBody informObjectId: IdDTO): ResponseEntity<Set<ComponentDTO>> {
        return ResponseEntity(
            componentService!!.getAllByInformatizationObjectId(informObjectId.id.toInt()),
            HttpStatus.OK
        )
    }

    @PostMapping("/create", consumes = ["application/json"], produces = ["application/json"])
    fun createComponent(@RequestBody component: NewComponentDTO): ResponseEntity<ComponentDTO> {
        return ResponseEntity(componentService!!.add(component), HttpStatus.CREATED)
    }

    @PostMapping("/update", consumes = ["application/json"], produces = ["application/json"])
    fun updateComponent(@RequestBody component: EditComponentDTO): ResponseEntity<ComponentDTO> {
        return ResponseEntity(componentService!!.edit(component), HttpStatus.OK)
    }

    @PostMapping("/delete", consumes = ["application/json"])
    fun deleteComponentById(@RequestBody componentId: IdDTO): ResponseEntity<HttpStatus> {
        componentService!!.deleteById(componentId.id.toInt())
        return ResponseEntity(HttpStatus.OK)
    }
}
