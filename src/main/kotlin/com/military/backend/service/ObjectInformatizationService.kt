package com.military.backend.service

import com.military.backend.domain.ObjectInformatizationModel

interface ObjectInformatizationService {

    fun add(informatizationObject: ObjectInformatizationModel): ObjectInformatizationModel
    fun get(id: Int): ObjectInformatizationModel
    fun edit(informatizationObject: ObjectInformatizationModel): ObjectInformatizationModel
    fun delete(informatizationObject: ObjectInformatizationModel)
    fun deleteById(informatizationObjectId: Int)

    fun getAllByMilitaryBaseId(militaryBaseId: Int?): Set<ObjectInformatizationModel>
    fun getAll(): Set<ObjectInformatizationModel>
}
