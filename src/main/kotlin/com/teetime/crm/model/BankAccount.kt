package com.teetime.crm.model

import com.teetime.crm.common.contant.BankAccountType
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Enumerated
import jakarta.persistence.EnumType
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity
@Table(name = "bank_accounts")
data class BankAccount(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),

    @Enumerated(EnumType.STRING)
    val category: BankAccountType,

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    val bank: Bank,

    @Column
    val accountNumber: String,

    @Column
    val ibanNumber: String,

    @Column
    val swiftNumber: String,

    @Column(nullable = false)
    val providerId: UUID,

    @Column(nullable = false)
    val resortId: UUID
)

