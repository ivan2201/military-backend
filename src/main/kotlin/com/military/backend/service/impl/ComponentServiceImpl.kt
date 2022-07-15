package com.military.backend.service.impl

import com.military.backend.domain.ComponentModel
import com.military.backend.repository.ComponentRepository
import com.military.backend.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ComponentServiceImpl: ComponentService {
    @Autowired
    lateinit var componentRepository: ComponentRepository

    override fun add(component: ComponentModel): ComponentModel
    {
        if (component.id == null || component.id == -1)
            return componentRepository.save(component)
        else
            throw Exception("Bad value")
    }

    override fun edit(component: ComponentModel): ComponentModel
    {
        if (component.id != null && component.id > 0)
            return componentRepository.save(component)
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): ComponentModel
    {
        return componentRepository.getOne(id)
    }

    override fun delete(component: ComponentModel)
    {
        componentRepository.delete(component)
    }

    override fun getAll(): List<ComponentModel> {
        return componentRepository.findAll()
    }

    override fun getAllByInformatizationObjectId(iOId: Int?): List<ComponentModel> {
        iOId?.let {
            return componentRepository.findAllByInformatizationObjectId(iOId)
        }
        return getAll()
    }
}
