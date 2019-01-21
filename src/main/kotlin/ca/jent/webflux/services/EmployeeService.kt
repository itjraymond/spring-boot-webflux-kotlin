package ca.jent.webflux.services

import ca.jent.webflux.repositories.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeService {

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    fun getAllEmployees() = employeeRepository.findAll()!!

}