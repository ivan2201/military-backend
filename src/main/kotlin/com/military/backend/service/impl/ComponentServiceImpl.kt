package com.military.backend.service.impl

import com.military.backend.domain.ComponentModel
import com.military.backend.domain.dto.ComponentDTO
import com.military.backend.repository.ComponentRepository
import com.military.backend.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ComponentServiceImpl: ComponentService {
    @Autowired
    var componentRepository: ComponentRepository? = null

    override fun add(component: ComponentDTO): ComponentDTO
    {
        if (component.id == -1)
            return ComponentDTO(componentRepository!!.save(ComponentModel(component)))
        else
            throw Exception("Bad value")
    }

    override fun edit(component: ComponentDTO): ComponentDTO
    {
        if (component.id > 0)
            return ComponentDTO(componentRepository!!.save(ComponentModel(component)))
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): ComponentDTO
    {
        return ComponentDTO(componentRepository!!.getOne(id))
    }

    override fun deleteById(componentId: Int) {
        componentRepository!!.deleteById(componentId)
    }

    override fun getAll(): Set<ComponentDTO> {
        return ComponentDTO.fromComponentModelSet(componentRepository!!.findAll().toSet())
    }

    override fun getAllByInformatizationObjectId(iOId: Int?): Set<ComponentDTO> {
        iOId?.let {
            return ComponentDTO.fromComponentModelSet(
                componentRepository!!.findAllByObjectInformatizationId(iOId)
            )
        }
        return getAll()
    }
}
