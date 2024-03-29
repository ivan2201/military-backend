package com.military.backend.service.impl

import com.military.backend.domain.ObjectInformatizationModel
import com.military.backend.domain.dto.EditObjectInformatizationDTO
import com.military.backend.domain.dto.NewObjectInformatizationDTO
import com.military.backend.domain.dto.ObjectInformatizationDTO
import com.military.backend.repository.*
import com.military.backend.service.ObjectInformatizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ObjectInformatizationServiceImpl: ObjectInformatizationService {
    @Autowired
    val objectInformatizationRepository: ObjectInformatizationRepository? = null

    @Autowired
    val militaryBaseRepository: MilitaryBaseRepository? = null

    @Autowired
    val certificateRepository: CertificateRepository? = null

    @Autowired
    val specialCheckResultRepository: SpecialCheckResultRepository? = null

    @Autowired
    val specialInvestigationRepository: SpecialInvestigationRepository? = null

    override fun add(informatizationObject: NewObjectInformatizationDTO): ObjectInformatizationDTO
    {
        return ObjectInformatizationDTO(objectInformatizationRepository!!.save(
                ObjectInformatizationModel(informatizationObject,
                    informatizationObject.mbId?.let { militaryBaseRepository!!.getOne(it) })))
    }

    override fun edit(informatizationObject: EditObjectInformatizationDTO): ObjectInformatizationDTO
    {
        return ObjectInformatizationDTO(objectInformatizationRepository!!.save(
            ObjectInformatizationModel(informatizationObject,
                informatizationObject.mbId?.let { militaryBaseRepository!!.getOne(it) },
                informatizationObject.certId?.let { certificateRepository!!.getOne(it) },
                informatizationObject.siId?.let { specialInvestigationRepository!!.getOne(it) },
                informatizationObject.scrId?.let { specialCheckResultRepository!!.getOne(it) }
                )))
    }

    override fun get(id: Int): ObjectInformatizationDTO
    {
        return ObjectInformatizationDTO(objectInformatizationRepository!!.getOne(id))
    }


    override fun deleteById(informatizationObjectId: Int) {
        objectInformatizationRepository!!.deleteById(informatizationObjectId)
    }

    override fun getAllByMilitaryBaseId(militaryBaseId: Int): Set<ObjectInformatizationDTO> {
        return ObjectInformatizationDTO.fromObjectInformatizationModelSet(
                    objectInformatizationRepository!!.findAllByMilitaryBaseId(militaryBaseId)
        )
    }

    override fun getAll(): Set<ObjectInformatizationDTO> {
        return ObjectInformatizationDTO.fromObjectInformatizationModelSet(
                objectInformatizationRepository!!.findAll().toSet()
        )
    }
}
