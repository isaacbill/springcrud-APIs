package com.isaac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
//@RequestMapping("/subcategories")
public class SubcategoryController {
	@Autowired
	SubcategoryService subcategoryService;
     CategoryService categoryService;

    public SubcategoryController(SubcategoryService subcategoryService, CategoryService categoryService) {
        this.subcategoryService = subcategoryService;
        this.categoryService = categoryService;
    }
    
    @GetMapping("/subcategories")
	 @ResponseBody 
	 public List<Subcategory> getAllCategories(){
		  List<Subcategory> subcategories = subcategoryService.getAllSubcategories();
	  
	  return subcategories;
	  }	    
    @GetMapping("/subcategories/add")
    public ResponseEntity<Map<String, Object>> showAddSubcategoryForm() {
    	List<Category> categories = categoryService.getAllCategories();
    	List<Subcategory> subcategories = subcategoryService.getAllSubcategories();
    	
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("categories", categories);
        responseData.put("subcategories", subcategories);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/subcategories/add")
    public ResponseEntity<String> addSubcategory(@RequestBody Subcategory subcategory) {
    	 try {
    	        subcategoryService.addSubcategory(subcategory);
    	        return ResponseEntity.ok("Subcategory added successfully");
    	    } catch (Exception e) {
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    	            .body("Failed to add subcategory: " + e.getMessage());
    	    }
    }
    @GetMapping("/subcategories/edit/{id}")
    public ResponseEntity<Subcategory> getSubcategoryById(@PathVariable("id") Integer id) {
        Subcategory subcategory = subcategoryService.getSubcategoryById(id);

        if (subcategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(subcategory);
    }

    @PostMapping("/subcategories/edit/{id}")
    public ResponseEntity<String> editSubcategory(@PathVariable("id") Integer id, @RequestBody Subcategory updatedSubcategory) {
        Subcategory existingSubcategory = subcategoryService.getSubcategoryById(id);

        if (existingSubcategory == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subcategory not found");
        }
        existingSubcategory.setName(updatedSubcategory.getName());
        existingSubcategory.setCategoryId(updatedSubcategory.getCategoryId());

        // Save the updated subcategory back to the database
        subcategoryService.editSubcategory(existingSubcategory);

        return ResponseEntity.ok("Subcategory updated successfully");
    }
    
    @DeleteMapping("/subcategories/delete/{id}")
    public ResponseEntity<String> deleteSubcategory(@PathVariable("id") Integer id) {
        Subcategory subcategory = subcategoryService.getSubcategoryById(id);
        if (subcategory == null) {
            return new ResponseEntity<>("subcategory not found", HttpStatus.NOT_FOUND);
        }

        subcategoryService.deleteSubcategory(id);

        return new ResponseEntity<>("subcategory deleted successfully", HttpStatus.OK);
    }
}
