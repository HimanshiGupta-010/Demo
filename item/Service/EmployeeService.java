package com.assign.item.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.item.Model.Employee;
import com.assign.item.Model.Item;
import com.assign.item.Repository.EmployeeRepository;
import com.assign.item.Repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private ItemRepository itemRepository;

    //get all employee
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
//get employee by id
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
// post employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    //put for emp form with deatails.
//    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee ,Item item) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        Optional<Item> optionalItem = itemRepository.findById(id);
//        if (optionalEmployee.isPresent()) {
//            Employee employee = optionalEmployee.get();
//           employee.setName(updatedEmployee.getName());
//           employee.setAssigned(item.getName());
//           employee.setItemId(item.getItem_id());
//            
//            return Optional.of(employeeRepository.save(employee));
//        }
//        return Optional.empty();
//    }
// put employee for updating in the form(already)
    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
          // employee.setEmp_id(updatedEmployee.getEmp_id());
            employee.setName(updatedEmployee.getName());
            employee.setItemId(updatedEmployee.getItemId());
            // Update other attributes as needed
            return Optional.of(employeeRepository.save(employee));
        }
        return Optional.empty();
    }
    
    
//delete employee by id 
    public boolean deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        }
        return false;
    }
}
