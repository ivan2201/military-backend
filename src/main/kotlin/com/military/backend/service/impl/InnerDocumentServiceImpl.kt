package com.military.backend.service.impl

import com.military.backend.domain.InnerDocumentModel
import com.military.backend.domain.dto.DocumentDTO
import com.military.backend.domain.dto.EditDocumentDTO
import com.military.backend.domain.dto.NewDocumentDTO
import com.military.backend.repository.InnerDocumentRepository
import com.military.backend.repository.ObjectInformatizationRepository
import com.military.backend.service.InnerDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InnerDocumentServiceImpl: InnerDocumentService {
    @Autowired
    var innerDocumentRepository: InnerDocumentRepository? = null

    @Autowired
    var objectInformatizationRepository: ObjectInformatizationRepository? = null

    override fun add(document: NewDocumentDTO): DocumentDTO
    {
        return DocumentDTO(innerDocumentRepository!!.save(
            InnerDocumentModel(document,
                document.oiId?.let { objectInformatizationRepository!!.getOne(it) }
        )))
    }

    override fun edit(document: EditDocumentDTO): DocumentDTO
    {
        return DocumentDTO(innerDocumentRepository!!.save(
            InnerDocumentModel(document,
                document.oiId?.let { objectInformatizationRepository!!.getOne(it) }
            )))
    }

    override fun get(id: Int): DocumentDTO
    {
        return DocumentDTO(innerDocumentRepository!!.getOne(id))
    }

    override fun deleteById(documentId: Int) {
        innerDocumentRepository!!.deleteById(documentId)
    }

    override fun getAllByInformatizationObjectId(iOId: Int?): Set<DocumentDTO> {
        iOId?.let {
            return DocumentDTO.fromInnerDocumentModelSet(
                innerDocumentRepository!!.findAllByObjectInformatizationId(iOId)
            )
        }
        return getAll()
    }

    override fun getAll(): Set<DocumentDTO> {
        return DocumentDTO.fromInnerDocumentModelSet(innerDocumentRepository!!.findAll().toSet())
    }
}
