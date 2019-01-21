package ca.jent.webflux.services

import ca.jent.webflux.domain.Employee
import ca.jent.webflux.repositories.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class EmployeeService {

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    fun getAllEmployees() = employeeRepository.findAll()

    fun getEmployee(id: String): Mono<Employee> = employeeRepository.findById(id)

}