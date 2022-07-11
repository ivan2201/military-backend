package com.military.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface InnerDocumentRepository : JpaRepository<InnerDocumentRepository, Int>
