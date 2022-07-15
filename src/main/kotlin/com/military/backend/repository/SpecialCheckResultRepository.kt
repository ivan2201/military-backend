package com.military.backend.repository

import com.military.backend.domain.SpecialCheckResultModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpecialCheckResultRepository : JpaRepository<SpecialCheckResultModel, Int>
