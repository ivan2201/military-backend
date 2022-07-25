package com.military.backend.service

import com.military.backend.domain.dto.ObjectInformatizationDTO

interface ObjectInformatizationService {

    fun add(informatizationObject: ObjectInformatizationDTO): ObjectInformatizationDTO
    fun get(id: Int): ObjectInformatizationDTO
    fun edit(informatizationObject: ObjectInformatizationDTO): ObjectInformatizationDTO
    fun deleteById(informatizationObjectId: Int)

    fun getAllByMilitaryBaseId(militaryBaseId: Int?): Set<ObjectInformatizationDTO>
    fun getAll(): Set<ObjectInformatizationDTO>
}
