package com.military.backend.domain.dto

import com.military.backend.domain.InnerDocumentModel

data class DocumentDTO(
    val id: Int,
    val name: String?,
    val regNum: String?,
    val date: String?
) {
    constructor(documentModel: InnerDocumentModel):
            this(documentModel.id!!, documentModel.name,
                documentModel.registrationNumber, documentModel.approveDate.toString())

    companion object {
        fun fromInnerDocumentModelSet(documents: Set<InnerDocumentModel>): Set<DocumentDTO>
        {
            val result = ArrayList<DocumentDTO>(documents.size)
            for (document in documents)
            {
                result.add(DocumentDTO(document))
            }
            return result.toSet()
        }
    }
}
