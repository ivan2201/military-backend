package com.military.backend.service

import com.military.backend.domain.MilitaryBaseModel

interface MilitaryBaseService {
    fun add(militaryBase: MilitaryBaseModel): MilitaryBaseModel
    fun edit(militaryBase: MilitaryBaseModel): MilitaryBaseModel
    fun get(id: Int): MilitaryBaseModel
    fun delete(militaryBase: MilitaryBaseModel)
    fun deleteById(militaryBaseId: Int)
    fun getAll(): Set<MilitaryBaseModel>
}
