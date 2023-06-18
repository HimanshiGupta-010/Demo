//package com.assign.item.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.assign.item.Model.Employee;
//import com.assign.item.Model.Item;
//import com.assign.item.Payload.ItemDataTransfer;
//import com.assign.item.Repository.EmployeeRepository;
//import com.assign.item.Repository.ItemRepository;
//
//import jakarta.persistence.EntityNotFoundException;
//
//
//public class AssignService {
//	
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	  @Autowired
//	    private ItemRepository itemRepository;
//	
//	public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        if (optionalEmployee.isPresent()) {
//            Employee employee = optionalEmployee.get();
//          // employee.setEmp_id(updatedEmployee.getEmp_id());
//            employee.setName(updatedEmployee.getName());
//           employee.setAssigned(updatedEmployee.getAssigned());
//            // Update other attributes as needed
//            return Optional.of(employeeRepository.save(employee));
//        }
//        return Optional.empty();
//    }
////	
////	public List<Item> getAllItems() {
////        return itemRepository.findAll();
////    }
////	
////	    public List<Item> getAttributesById(Long id) {
////	        Optional<Item> optionalEntity = itemRepository.findById(id);
////	        if (optionalEntity.isPresent()) {
////	            Item entity = optionalEntity.get();
////	           // ItemRepository dto;
////	            entity.setItem_id(entity.getItem_id());
////	            entity.setName(entity.getName());
////	            return (List<Item>) entity;
////	        } else {
////	            throw new EntityNotFoundException();
////	        }
////	    }
//	    public List<ItemDataTransfer> getAllItems() {
//	        List<Item> items = itemRepository.findAll();
//	        return  items.stream()
//	                .map(item -> new ItemDataTransfer(item.getItem_id(), item.getName()))
//	                .collect(Collectors.toList());
//	        
//	    }
//}
//	