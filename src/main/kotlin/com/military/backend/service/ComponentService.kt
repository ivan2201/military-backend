package com.military.backend.service

import com.military.backend.domain.dto.ComponentDTO
import com.military.backend.domain.dto.EditComponentDTO
import com.military.backend.domain.dto.NewComponentDTO

interface ComponentService {
    fun add(component: NewComponentDTO): ComponentDTO
    fun edit(component: EditComponentDTO): ComponentDTO
    fun get(id: Int): ComponentDTO
    fun deleteById(componentId: Int)
    fun getAll(): Set<ComponentDTO>
    fun getAllByInformatizationObjectId(iOId: Int?): Set<ComponentDTO>
}
