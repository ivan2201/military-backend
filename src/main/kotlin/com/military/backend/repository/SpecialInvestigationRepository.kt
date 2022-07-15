package com.military.backend.repository

import com.military.backend.domain.SpecialInvestigationModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpecialInvestigationRepository : JpaRepository<SpecialInvestigationModel, Int>
