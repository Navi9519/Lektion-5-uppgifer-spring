package com.navi.web_api_db_lektion_5.__uppgifter

import com.navi.web_api_db_lektion_5.__uppgifter.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomUserRepository: JpaRepository<CustomUser, Long> {

}