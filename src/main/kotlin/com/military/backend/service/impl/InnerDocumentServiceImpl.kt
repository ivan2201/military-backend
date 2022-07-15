package com.military.backend.service.impl

import com.military.backend.domain.InnerDocumentModel
import com.military.backend.repository.InnerDocumentRepository
import com.military.backend.service.InnerDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InnerDocumentServiceImpl: InnerDocumentService {
    @Autowired
    lateinit var innerDocumentRepository: InnerDocumentRepository

    override fun add(document: InnerDocumentModel): InnerDocumentModel
    {
        if (document.id == null || document.id == -1)
            return innerDocumentRepository.save(document)
        else
            throw Exception("Bad value")
    }

    override fun edit(document: InnerDocumentModel): InnerDocumentModel
    {
        if (document.id != null && document.id > 0)
            return innerDocumentRepository.save(document)
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): InnerDocumentModel
    {
        return innerDocumentRepository.getOne(id)
    }

    override fun delete(document: InnerDocumentModel)
    {
        innerDocumentRepository.delete(document)
    }

    override fun getAllByInformatizationObjectId(iOId: Int?): List<InnerDocumentModel> {
        iOId?.let {
            return innerDocumentRepository.findAllByInformatizationObjectId(iOId)
        }
        return getAll()
    }

    override fun getAll(): List<InnerDocumentModel> {
        return innerDocumentRepository.findAll()
    }
}