package com.teetime.crm.controller

import com.teetime.crm.model.BankAccount
import com.teetime.crm.service.BankAccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/bank-accounts")
class BankAccountController(private val bankAccountService: BankAccountService) {

    @GetMapping
    fun getAllBankAccounts(): ResponseEntity<List<BankAccount>> =
        ResponseEntity.ok(bankAccountService.getAllBankAccounts())

    @GetMapping("/{id}")
    fun getBankAccountById(
        @PathVariable id: UUID
    ): ResponseEntity<BankAccount> =
        bankAccountService.getBankAccountById(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createBankAccount(
        @RequestBody bankAccount: BankAccount
    ): ResponseEntity<BankAccount> =
        ResponseEntity.status(
            HttpStatus.CREATED
        ).body(bankAccountService.createBankAccount(bankAccount))

    @PutMapping("/{id}")
    fun updateBankAccount(
        @PathVariable id: UUID,
        @RequestBody bankAccount: BankAccount
    ): ResponseEntity<BankAccount> =
        bankAccountService.updateBankAccount(id, bankAccount)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteBankAccount(
        @PathVariable id: UUID
    ): ResponseEntity<Void> =
        if (bankAccountService.deleteBankAccount(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
}
