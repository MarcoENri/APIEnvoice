package com.example.enterpriceAPI.repository

import com.example.enterpriceAPI.model.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository: JpaRepository<Country, Long> {
    fun findById (id:Long?):Country?
}