package com.example.enterpriceAPI.repository

import com.example.enterpriceAPI.model.Merchant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MerchantRepository: JpaRepository<Merchant, Long> {
    fun  findById(merchantId: Long?): Merchant?
}