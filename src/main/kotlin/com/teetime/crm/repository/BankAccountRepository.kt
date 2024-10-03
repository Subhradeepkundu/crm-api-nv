package com.teetime.crm.repository

import com.teetime.crm.model.BankAccount
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BankAccountRepository : JpaRepository<BankAccount, UUID>