package com.teetime.crm.service

import com.teetime.crm.model.Bank
import com.teetime.crm.repository.BankRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BankService(private val bankRepository: BankRepository) {

    fun getAllBanks(): List<Bank> = bankRepository.findAll()

    fun getBankById(id: UUID): Bank? = bankRepository.findById(id).orElse(null)

    fun createBank(bank: Bank): Bank = bankRepository.save(bank)

    fun updateBank(id: UUID, updatedBank: Bank): Bank? {
        return bankRepository.findById(id).map {
            val bankToSave = it.copy(name = updatedBank.name,
            logo = updatedBank.logo) // Add other fields as needed
            bankRepository.save(bankToSave)
        }.orElse(null)
    }

    fun deleteBank(id: UUID): Boolean {
        return if (bankRepository.existsById(id)) {
            bankRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
