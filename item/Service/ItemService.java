package com.assign.item.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.item.Model.Employee;
import com.assign.item.Model.Item;
import com.assign.item.Repository.EmployeeRepository;
//import com.assign.item.Payload.ItemDataTransfer;
import com.assign.item.Repository.ItemRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {
//	
//	public ItemService(ItemRepository itemRepository) {
//	        this.itemRepository = itemRepository;
//	    }
//	

    @Autowired
    private ItemRepository itemRepository;
    private EmployeeRepository employeeRepository;
//get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    //get only two fields of item.(name and id)
//    public List<Item> getOnlyTwo(){
//    	List<Item> iobj = itemRepository.findAll();
//    	 return iobj.stream()
//                 .map(item -> new Item(item.getItem_id(), item.getName()))
//                 .collect(Collectors.toList());
//    	
//    }
    
//    public void assignItemToEmployee(Long employeeId, Long itemId) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + employeeId));
//
//        Item item = itemRepository.findById(itemId)
//                .orElseThrow(() -> new EntityNotFoundException("Item not found with ID: " + itemId));
//
//        employee.setAssigned(item.getName());
//        employee.setItemId(item.getItem_id());
//
//        employeeRepository.save(employee);
//    }
    
    //Put of employee for setting the item name and id in the form.
    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee ,Item item) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
           employee.setName(updatedEmployee.getName());
           employee.setItemId(item.getItem_id());
            
            return Optional.of(employeeRepository.save(employee));
        }
        return Optional.empty();
    }
    
    
    
    
//get item by id.
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id); 
    }

    //post creating an item
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    //put for updating an item
    public Optional<Item> updateItem(Long id, Item updatedItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setName(updatedItem.getName());
            item.setStatus(updatedItem.getStatus());
            // Update other attributes as needed
            
            return Optional.of(itemRepository.save(item));
        }
        return Optional.empty();
    }
    
    //for updating status
    public Optional<Item> updateStatus(Long id){
    	Optional<Item> optionalItem = itemRepository.findById(id);
    	if(optionalItem.isPresent()) {
    		Item item = optionalItem.get();
    		item.setStatus(true);
    		return Optional.of(itemRepository.save(item));
    	}
    	return Optional.empty();
    }
    
//delete an item by id
    public boolean deleteItem(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            itemRepository.delete(optionalItem.get());
            return true;
        }
        return false;
    }
}
