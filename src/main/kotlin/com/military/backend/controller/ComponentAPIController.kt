package com.military.backend.controller

import com.military.backend.domain.dto.ComponentDTO
import com.military.backend.domain.dto.EditComponentDTO
import com.military.backend.domain.dto.IdDTO
import com.military.backend.domain.dto.NewComponentDTO
import com.military.backend.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ComponentAPIController {

    @Autowired
    var componentService: ComponentService? = null

    @GetMapping("api/components")
    fun getComponents():
            Set<ComponentDTO> {
        return componentService!!.getAll()
    }

    @GetMapping("api/components/by-inform-object")
    fun getComponentsByMilitaryBaseId(@RequestBody informObjectId: IdDTO):
            Set<ComponentDTO> {
        return componentService!!.getAllByInformatizationObjectId(informObjectId.id.toInt())
    }

    @GetMapping("api/component")
    fun getComponent(@RequestBody componentId: IdDTO): ComponentDTO {
        return componentService!!.get(componentId.id.toInt())
    }

    @PostMapping("api/component/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createComponent(@RequestBody component: NewComponentDTO):
            ComponentDTO {
        return componentService!!.add(component)
    }

    @PostMapping("api/component/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateComponent(@RequestBody component: EditComponentDTO):
            ComponentDTO {
        return componentService!!.edit(component)
    }

    @PostMapping("api/component/delete")
    fun deleteComponentById(@RequestBody componentId: IdDTO)
    {
        componentService!!.deleteById(componentId.id.toInt())
    }
}
