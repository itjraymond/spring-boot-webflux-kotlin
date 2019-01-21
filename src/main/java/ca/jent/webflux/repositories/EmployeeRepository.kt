package ca.jent.webflux.repositories

import ca.jent.webflux.domain.Employee
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository: ReactiveCassandraRepository<String, Employee>
