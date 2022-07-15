package com.military.backend.service.impl

import com.military.backend.domain.SpecialInvestigationModel
import com.military.backend.repository.SpecialInvestigationRepository
import com.military.backend.service.SpecialInvestigationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SpecialInvestigationServiceImpl: SpecialInvestigationService {
    @Autowired
    var specialInvestigationRepository: SpecialInvestigationRepository? = null

    override fun add(specInvestigation: SpecialInvestigationModel): SpecialInvestigationModel
    {
        if (specInvestigation.id == null || specInvestigation.id == -1)
            return specialInvestigationRepository!!.save(specInvestigation)
        else
            throw Exception("Bad value")
    }

    override fun edit(specInvestigation: SpecialInvestigationModel): SpecialInvestigationModel
    {
        if (specInvestigation.id != null && specInvestigation.id > 0)
            return specialInvestigationRepository!!.save(specInvestigation)
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): SpecialInvestigationModel
    {
        return specialInvestigationRepository!!.getOne(id)
    }

    override fun delete(specInvestigation: SpecialInvestigationModel)
    {
        specialInvestigationRepository!!.delete(specInvestigation)
    }

    override fun deleteById(specInvestigationId: Int) {
        specialInvestigationRepository!!.deleteById(specInvestigationId)
    }

    override fun getAll(): Set<SpecialInvestigationModel> {
        return specialInvestigationRepository!!.findAll().toSet()
    }
}
