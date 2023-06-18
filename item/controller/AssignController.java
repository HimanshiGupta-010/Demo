//package com.assign.item.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.view.RedirectView;
//
//import com.assign.item.Model.Employee;
//import com.assign.item.Model.Item;
//import com.assign.item.Payload.ItemDataTransfer;
//import com.assign.item.Repository.ItemRepository;
//import com.assign.item.Service.AssignService;
//import com.assign.item.Service.EmployeeService;
//import com.assign.item.Service.ItemService;
//
//import jakarta.persistence.EntityNotFoundException;
//
//	
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/assign")
//@Service
//public class AssignController {
//	 
//	@Autowired
//	private EmployeeService employeeService;
//	private ItemService itemService;
//	private Item item;
//	public String Product_Name; 
//	private Employee employee;
//	private AssignService assignService;
//	
//	//ON CLICKING THE ASSIGN BUTTON FROM EMPLOYEE LIST.
//	//calling put method  of employee for updating details in form with Item name and Id field.
//   // calling item getallitems(only name and id)
//   
//	@PutMapping("/Eapi/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee updatedEmployee) {
//        Optional<Employee> optionalEmployee = employeeService.updateEmployee(id,updatedEmployee);
//        employee.setEmp_id(updatedEmployee.getEmp_id());
//        employee.setName(updatedEmployee.getName());
//        //employee.setAssigned(Product_Name);
//        //service class
//        if (optionalEmployee.isPresent()) {
//            return ResponseEntity.ok(optionalEmployee.get());
//        }
//        return ResponseEntity.notFound().build();
//	}
//	
////	    @GetMapping("/Iapi")
////	    public ResponseEntity<List<Item>> getAttributesById() {
////	        try {
////	            List<Item> items = itemService.getAttributesById(id);
////	            return ResponseEntity.ok(items);
////	        } catch (EntityNotFoundException e) {
////	            return ResponseEntity.notFound().build();
////	        }
////}
//	    
//	    @GetMapping
//	    public ResponseEntity<List<ItemDataTransfer>> getAllItems() {
//	        List<ItemDataTransfer> i = assignService.getAllItems();
//	        if (i.isEmpty()) {
//	            return ResponseEntity.noContent().build();
//	        } else {
//	            return ResponseEntity.ok(i);
//	        }
//}
//}
////@GetMapping("/{id}")
////public ResponseEntity<Item> getItemById(@PathVariable Long id , String Name) {
////    Optional<Item> optionalItem = itemService.getItemById(id);
////    if (optionalItem.isPresent()) {
////    	if(optionalItem.map(Item::getName).equals(item.getName())) {
////    		
////    		String Product_Name =  optionalItem.map(Item::getName).orElse(null);  
////    		//getEmployeeById(Long id);
////    		
////    	}
////    	
////        return ResponseEntity.ok(optionalItem.get());
////    }
////    return ResponseEntity.notFound().build();
////}
//
//
////Id enter krke get details of employee krenge to employee ki sari details fill hokar aaani chahiye
////Item assigned field me item ke name ke sath.
//
////uske bad save button pr click krte hi vo item table me show ho jani chahiye 
////@GetMapping("/employees")
////public ResponseEntity<List<Employee>>getAllEmployees() {
////    List<Employee> employees = employeeService.getAllEmployees();
////    return ResponseEntity.ok(employees);
////}
////@GetMapping("/{id}")
////public RedirectView getItemById(@PathVariable Long id) {
////     Optional<Item> optionalItem = itemService.getItemById(id);
////    if (optionalItem.isPresent()) {
////     	if(optionalItem.map(Item::getName).equals(item.getName())) {
////     		
////     		 Product_Name =  optionalItem.map(Item::getName).orElse(null); 
////     	}
////     		return new RedirectView("/employees");
////         
////     	}
////     else return null;
////     
////	}