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
//@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	 CategoryService categoryService;

	    @GetMapping("/categories")
		 @ResponseBody 
		 public List<Category> getAllCategories(){
			  List<Category> categories = categoryService.getAllCategories();
		  
		  return categories;
		  }
	    @GetMapping("/categories/add")
	    public ResponseEntity<Map<String, Object>> showAddCategoryForm() {
	        List<Category> categories = categoryService.getAllCategories();
	        Map<String, Object> responseData = new HashMap<>();
	        responseData.put("categories", categories);
	   
	        return new ResponseEntity<>(responseData, HttpStatus.OK);
	    }

	    @PostMapping("/categories/add")
	    public ResponseEntity<String> addCategory(@RequestBody Category category) {
	        categoryService.addCategory(category);
	        return ResponseEntity.ok("Category added successfully");
	    }
	    
	    @GetMapping("/categories/edit/{id}")
	    public ResponseEntity<Map<String, Object>> showEditCategoryForm(@PathVariable("id") Integer id) {
	    	Category category = categoryService.getCategoryById(id);
	        if (category == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        List<Category> categories = categoryService.getAllCategories();
	        Map<String, Object> responseData = new HashMap<>();
	        responseData.put("categories", categories);

	        return new ResponseEntity<>(responseData, HttpStatus.OK);
	    }
	    @PostMapping("/categories/edit/{id}")
	    public ResponseEntity<String> editProduct(@PathVariable("id") Integer id, @RequestBody Products product) {
	        Category existingCategory = categoryService.getCategoryById(id);
	        if (existingCategory == null) {
	            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
	        }

	        // Update the existing category with the new data
	        existingCategory.setName(product.getName());
	        categoryService.editCategory(existingCategory);

	        return new ResponseEntity<>("Category updated successfully", HttpStatus.OK);
	    }

	    @DeleteMapping("/categories/delete/{id}")
	    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id) {
	        Category category = categoryService.getCategoryById(id);
	        if (category == null) {
	            return new ResponseEntity<>("category not found", HttpStatus.NOT_FOUND);
	        }

	        categoryService.deleteCategory(id);

	        return new ResponseEntity<>("category deleted successfully", HttpStatus.OK);
	    }

}
