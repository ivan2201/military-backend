package com.military.backend.service

import com.military.backend.domain.SpecialCheckResultModel
import com.military.backend.domain.dto.SpecialCheckResultDTO

interface SpecialCheckResultService {
    fun addOrEdit(specCheckResult: SpecialCheckResultDTO)
//    fun edit(specCheckResult: SpecialCheckResultModel): SpecialCheckResultModel
    fun get(id: Int): SpecialCheckResultModel
    fun deleteById(specCheckResultId: Int)
    fun getAll(): Set<SpecialCheckResultModel>
}
