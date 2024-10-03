package com.teetime.crm.model

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "banks")
data class Bank(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val name: String,

    // Add more fields like logo, etc.
    @Column(nullable = true)
    val logo: String? = null
)
