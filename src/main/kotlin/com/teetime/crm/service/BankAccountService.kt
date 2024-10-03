package com.teetime.crm.service

import com.teetime.crm.model.BankAccount
import com.teetime.crm.repository.BankAccountRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BankAccountService(private val bankAccountRepository: BankAccountRepository) {

    fun getAllBankAccounts(): List<BankAccount> = bankAccountRepository.findAll()

    fun getBankAccountById(id: UUID): BankAccount? = bankAccountRepository.findById(id).orElse(null)

    fun createBankAccount(bankAccount: BankAccount): BankAccount = bankAccountRepository.save(bankAccount)

    fun updateBankAccount(id: UUID, updatedBankAccount: BankAccount): BankAccount? {
        return bankAccountRepository.findById(id).map {
            val bankAccountToSave = it.copy(
                accountNumber = updatedBankAccount.accountNumber,
                ibanNumber = updatedBankAccount.ibanNumber,
                swiftNumber = updatedBankAccount.swiftNumber,
                category = updatedBankAccount.category
                // Add other fields as needed
            )
            bankAccountRepository.save(bankAccountToSave)
        }.orElse(null)
    }

    fun deleteBankAccount(id: UUID): Boolean {
        return if (bankAccountRepository.existsById(id)) {
            bankAccountRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
