package com.teetime.crm.repository

import com.teetime.crm.model.Bank
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BankRepository : JpaRepository<Bank, UUID>