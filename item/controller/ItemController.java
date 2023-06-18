package com.assign.item.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assign.item.Model.Employee;
import com.assign.item.Model.Item;
import com.assign.item.Service.EmployeeService;
//import com.assign.item.Payload.ItemDataTransfer;
import com.assign.item.Service.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@CrossOrigin("*")
public class ItemController {

    @Autowired
    private ItemService itemService;
   private EmployeeService employeeService;
    Employee employee;

  //update status
    @PutMapping("/status/{id}")
    public ResponseEntity<Item> updateStatus(@PathVariable Long id) {
        Optional<Item> optionalItem = itemService.updateStatus(id);
        if (optionalItem.isPresent()) {
        	//itemStatus = True;
            return ResponseEntity.ok(optionalItem.get());
        }
        return ResponseEntity.notFound().build();
    }

    //get all items 
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    
    //get only two fields name and id of item.
    @GetMapping("/nameandid")
    public ResponseEntity<List<Item>> getOnlyTwo(){
    	 List<Item> items = itemService.getAllItems();
         return ResponseEntity.ok(items);  
    	    }
    
//    @PutMapping("/empform")
//    public ResponseEntity<String> assignItemToEmployee(
//            @RequestParam("emp_id") Long emp_id,
//            @RequestParam("item_Id") Long item_id
//    ) {
//        itemService.assignItemToEmployee(emp_id, item_id);
//        return ResponseEntity.ok("Item assigned to employee successfully.");
//    }
//    
    
  //Put of employee for setting the item name and id in the form.
//    @PutMapping("/Eapi/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee updatedEmployee) {
//      Optional<Employee> optionalEmployee = employeeService.updateEmployee(id,updatedEmployee);
//     // Optional<Item> optionalItem = itemService.updateEmployee(id, updatedEmployee, item)
//      employee.setEmp_id(updatedEmployee.getEmp_id());
//      employee.setName(updatedEmployee.getName()); 
//      employee.setItemId(updatedEmployee.getItemId());
//      employee.setAssigned(updatedEmployee.getAssigned());
//      
//      if (optionalEmployee.isPresent()) {
//          return ResponseEntity.ok(optionalEmployee.get());
//      }
//      return ResponseEntity.notFound().build();
//} 
    //get item by id .
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> optionalItem = itemService.getItemById(id);
        if (optionalItem.isPresent()) {
            return ResponseEntity.ok(optionalItem.get());
        }
        return ResponseEntity.notFound().build();
    }
//post to create an item
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }
//put for updating the item.
   @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        Optional<Item> optionalItem = itemService.updateItem(id, updatedItem);
        if (optionalItem.isPresent()) {
        	//itemStatus = True;
            return ResponseEntity.ok(optionalItem.get());
        }
        return ResponseEntity.notFound().build();
    }
   
   
   //deleting the item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean deleted = itemService.deleteItem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
