package com.military.backend.repository

import com.military.backend.domain.MilitaryBaseModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MilitaryBaseRepository : JpaRepository<MilitaryBaseModel, Int>
