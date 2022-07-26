package com.military.backend.domain.dto

import com.military.backend.domain.MilitaryBaseModel

data class WarCampDTO(
    val id: Int,
    val nameWarCamp: String?,
    val numberWarCamp: String?,
    val location: String?
) {
    constructor(militaryBaseModel: MilitaryBaseModel):
            this(militaryBaseModel.id!!, militaryBaseModel.name,
                militaryBaseModel.baseNumber, militaryBaseModel.location)

    companion object {
        fun fromMilitaryBaseModelSet(militaryBases: Set<MilitaryBaseModel>): Set<WarCampDTO>
        {
            val result = ArrayList<WarCampDTO>(militaryBases.size)
            for (militaryBase in militaryBases)
            {
                result.add(WarCampDTO(militaryBase))
            }
            return result.toSet()
        }
    }
}