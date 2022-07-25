package com.military.backend.service

import com.military.backend.domain.dto.ComponentDTO

interface ComponentService {
    fun add(component: ComponentDTO): ComponentDTO
    fun edit(component: ComponentDTO): ComponentDTO
    fun get(id: Int): ComponentDTO
    fun deleteById(componentId: Int)
    fun getAll(): Set<ComponentDTO>
    fun getAllByInformatizationObjectId(iOId: Int?): Set<ComponentDTO>
}
