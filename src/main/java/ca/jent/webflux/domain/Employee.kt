package ca.jent.webflux.domain

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.time.LocalDate

@Table
data class Employee(
        @PrimaryKey val id: String,
        val firstname: String,
        val lastname: String,
        val dob: LocalDate,
        val position: String
)