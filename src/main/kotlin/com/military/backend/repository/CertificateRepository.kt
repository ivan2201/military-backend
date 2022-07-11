package com.military.backend.repository

import com.military.backend.domain.CertificateModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CertificateRepository : JpaRepository<CertificateModel, Int>
