package com.military.backend.service

import com.military.backend.domain.SpecialInvestigationModel

interface SpecialInvestigationService {
    fun add(specInvestigation: SpecialInvestigationModel): SpecialInvestigationModel
    fun edit(specInvestigation: SpecialInvestigationModel): SpecialInvestigationModel
    fun get(id: Int): SpecialInvestigationModel
    fun delete(specInvestigation: SpecialInvestigationModel)
    fun deleteById(specInvestigationId: Int)
    fun getAll(): Set<SpecialInvestigationModel>
}
