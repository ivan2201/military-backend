package com.military.backend.service

import com.military.backend.domain.ComponentModel

interface ComponentService {
    fun add(component: ComponentModel): ComponentModel
    fun edit(component: ComponentModel): ComponentModel
    fun get(id: Int): ComponentModel
    fun delete(component: ComponentModel)
    fun deleteById(componentId: Int)
    fun getAll(): Set<ComponentModel>
    fun getAllByInformatizationObjectId(iOId: Int?): Set<ComponentModel>
}
