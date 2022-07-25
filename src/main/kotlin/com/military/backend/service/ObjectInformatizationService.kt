package com.military.backend.service

import com.military.backend.domain.dto.EditObjectInformatizationDTO
import com.military.backend.domain.dto.NewObjectInformatizationDTO
import com.military.backend.domain.dto.ObjectInformatizationDTO

interface ObjectInformatizationService {

    fun add(informatizationObject: NewObjectInformatizationDTO): ObjectInformatizationDTO
    fun get(id: Int): ObjectInformatizationDTO
    fun edit(informatizationObject: EditObjectInformatizationDTO): ObjectInformatizationDTO
    fun deleteById(informatizationObjectId: Int)

    fun getAllByMilitaryBaseId(militaryBaseId: Int): Set<ObjectInformatizationDTO>
    fun getAll(): Set<ObjectInformatizationDTO>
}
