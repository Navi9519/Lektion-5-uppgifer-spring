package com.navi.web_api_db_lektion_5.__uppgifter.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class CustomUser(
   @Id @GeneratedValue(strategy = GenerationType.AUTO )
     val id: Long?,
    val name: String,
    val password: String,
    val isEnables: Boolean
)