package ca.jent.webflux.controllers

import ca.jent.webflux.services.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController {

    @Autowired
    lateinit var employeeService: EmployeeService

    @GetMapping("/employees")
    fun getAllEmployees() = employeeService.getAllEmployees()

    @GetMapping("/employees/{id}")
    fun getEmployee(@PathVariable("id") id: String) = employeeService.getEmployee(id)
}