package com.military.backend.service

import com.military.backend.domain.SpecialCheckResultModel

interface SpecialCheckResultService {
    fun add(specCheckResult: SpecialCheckResultModel): SpecialCheckResultModel
    fun edit(specCheckResult: SpecialCheckResultModel): SpecialCheckResultModel
    fun get(id: Int): SpecialCheckResultModel
    fun delete(specCheckResult: SpecialCheckResultModel)
    fun getAll(): Set<SpecialCheckResultModel>
}
