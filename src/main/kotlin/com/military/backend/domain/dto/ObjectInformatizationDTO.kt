package com.military.backend.domain.dto

import com.military.backend.domain.ObjectInformatizationModel
import java.text.SimpleDateFormat

data class ObjectInformatizationDTO(
    val id: Int,
    val name: String?,
    val dateUpdate: String?,
    val numberOfDocuments: String?,
    val cert: CertificateDTO?,
    val si: SpecialInvestigationDTO?,
    val scr: SpecialCheckResultDTO?
) {

    constructor(model: ObjectInformatizationModel) : this(
        model.id!!,
        model.name,
        model.created.toString(),
        model.innerDocuments?.size.toString(),
        model.cert.let {
            CertificateDTO(
                id = it?.id ?: -1,
                numberCert = it?.certNumber,
                dateCreateCert = dateFormatter.format(it?.approveDate),
                dateFinishCert = dateFormatter.format(it?.recertDate),
                category = it?.category?.categoryName,
                owner = it?.certCreator
            )
        },
        model.specialInvestigation.let {
            SpecialInvestigationDTO(
                id = it?.id ?: -1,
                numberDoc = it?.specialInvestigationNumber,
                dateCheck = dateFormatter.format(it?.approveDate)
            )
        },
        model.specialCheckResult.let {
            SpecialCheckResultDTO(
                id = it?.id ?: -1,
                numberDoc = it?.specialCheckResultNumber,
                dateCheck = dateFormatter.format(it?.approveDate)
            )
        }
    )

    companion object {

        val dateFormatter = SimpleDateFormat("yyyy-mm-dd")

        fun fromObjectInformatizationModelSet(documents: Set<ObjectInformatizationModel>): Set<ObjectInformatizationDTO> {
            val result = ArrayList<ObjectInformatizationDTO>(documents.size)
            for (document in documents) {
                result.add(ObjectInformatizationDTO(document))
            }
            return result.toSet()
        }
    }
}
