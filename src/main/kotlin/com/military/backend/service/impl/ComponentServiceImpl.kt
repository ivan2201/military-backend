package com.military.backend.service.impl

import com.military.backend.domain.ComponentModel
import com.military.backend.domain.dto.ComponentDTO
import com.military.backend.domain.dto.EditComponentDTO
import com.military.backend.domain.dto.NewComponentDTO
import com.military.backend.repository.ComponentRepository
import com.military.backend.repository.ObjectInformatizationRepository
import com.military.backend.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ComponentServiceImpl: ComponentService {
    @Autowired
    var componentRepository: ComponentRepository? = null

    @Autowired
    val objectInformatizationRepository: ObjectInformatizationRepository? = null

    override fun add(component: NewComponentDTO): ComponentDTO
    {
        return ComponentDTO(componentRepository!!.save(ComponentModel(component,
            component.id?.let { objectInformatizationRepository!!.getOne(it) })))
    }

    override fun edit(component: EditComponentDTO): ComponentDTO
    {
        return ComponentDTO(componentRepository!!.save(ComponentModel(component,
            component.oiId?.let { objectInformatizationRepository!!.getOne(it) })))
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
