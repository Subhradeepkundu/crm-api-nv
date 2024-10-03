package com.teetime.crm.controller

import com.teetime.crm.model.Bank
import com.teetime.crm.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/banks")
class BankController(private val bankService: BankService) {

    @GetMapping
    fun getAllBanks(): ResponseEntity<List<Bank>> =
        ResponseEntity.ok(bankService.getAllBanks())

    @GetMapping("/{id}")
    fun getBankById(
        @PathVariable id: UUID
    ): ResponseEntity<Bank> =
        bankService.getBankById(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createBank(
        @RequestBody bank: Bank
    ): ResponseEntity<Bank> =
        ResponseEntity.status(
            HttpStatus.CREATED
        ).body(bankService.createBank(bank))

    @PutMapping("/{id}")
    fun updateBank(
        @PathVariable id: UUID,
        @RequestBody bank: Bank
    ): ResponseEntity<Bank> =
        bankService.updateBank(id, bank)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteBank(
        @PathVariable id: UUID
    ): ResponseEntity<Void> =
        if (bankService.deleteBank(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
}
