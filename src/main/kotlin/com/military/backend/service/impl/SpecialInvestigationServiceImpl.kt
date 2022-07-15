package com.military.backend.service.impl

import com.military.backend.domain.SpecialInvestigationModel
import com.military.backend.repository.SpecialInvestigationRepository
import com.military.backend.service.SpecialInvestigationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SpecialInvestigationServiceImpl: SpecialInvestigationService {
    @Autowired
    lateinit var specialInvestigationRepository: SpecialInvestigationRepository

    override fun add(specInvestigation: SpecialInvestigationModel): SpecialInvestigationModel
    {
        if (specInvestigation.id == null || specInvestigation.id == -1)
            return specialInvestigationRepository.save(specInvestigation)
        else
            throw Exception("Bad value")
    }

    override fun edit(specInvestigation: SpecialInvestigationModel): SpecialInvestigationModel
    {
        if (specInvestigation.id != null && specInvestigation.id > 0)
            return specialInvestigationRepository.save(specInvestigation)
        else
            throw Exception("Bad value")
    }

    override fun get(id: Int): SpecialInvestigationModel
    {
        return specialInvestigationRepository.getOne(id)
    }

    override fun delete(specInvestigation: SpecialInvestigationModel)
    {
        specialInvestigationRepository.delete(specInvestigation)
    }

    override fun getAll(): List<SpecialInvestigationModel> {
        return specialInvestigationRepository.findAll()
    }
}
