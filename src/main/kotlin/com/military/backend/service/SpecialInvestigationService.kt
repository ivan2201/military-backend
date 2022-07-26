package com.military.backend.service

import com.military.backend.domain.SpecialInvestigationModel
import com.military.backend.domain.dto.SpecialInvestigationDTO

interface SpecialInvestigationService {
    fun addOrEdit(specInvestigation: SpecialInvestigationDTO)
//    fun edit(specInvestigation: SpecialInvestigationModel): SpecialInvestigationModel
    fun get(id: Int): SpecialInvestigationModel
    fun deleteById(specInvestigationId: Int)
    fun getAll(): Set<SpecialInvestigationModel>
}
