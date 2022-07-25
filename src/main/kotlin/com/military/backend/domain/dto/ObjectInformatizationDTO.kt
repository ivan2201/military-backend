package com.military.backend.domain.dto

import com.military.backend.domain.ObjectInformatizationModel

data class ObjectInformatizationDTO(
    val id: Int,
    val name: String?,
    val dateUpdate: String?,
    val numberOfDocuments: String?,
    val cert: String?,
    val si: String?,
    val scr: String?
) {
    constructor(model: ObjectInformatizationModel):
            this(model.id!!,
                 model.name,
                 model.created.toString(),
                 model.innerDocuments?.size.toString(),
                 model.cert?.certNumber,
                 model.specialInvestigation?.specialInvestigationNumber,
                 model.specialCheckResult?.specialCheckResultNumber)

    companion object {
        fun fromObjectInformatizationModelSet(documents: Set<ObjectInformatizationModel>): Set<ObjectInformatizationDTO>
        {
            val result = ArrayList<ObjectInformatizationDTO>(documents.size)
            for (document in documents)
            {
                result.add(ObjectInformatizationDTO(document))
            }
            return result.toSet()
        }
    }
}
