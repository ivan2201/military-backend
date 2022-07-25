package com.military.backend.service

import com.military.backend.domain.dto.WarCampDTO

interface MilitaryBaseService {
    fun add(militaryBase: WarCampDTO): WarCampDTO
    fun edit(militaryBase: WarCampDTO): WarCampDTO
    fun get(id: Int): WarCampDTO
    fun deleteById(militaryBaseId: Int)
    fun getAll(): Set<WarCampDTO>
}
