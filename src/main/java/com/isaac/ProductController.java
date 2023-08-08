package com.isaac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;

    public ProductController(ProductService productService, CategoryService categoryService,
                             SubcategoryService subcategoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.subcategoryService = subcategoryService;
    }
	

	 @GetMapping("/products")
	 @ResponseBody public List<Products> getallproducts(){
		  List<Products> products = productService.getAllProducts();
	  
	  return products;
	  }
	    
	 @GetMapping("/products/add")
	    public ResponseEntity<Map<String, Object>> showAddProductForm() {
	        List<Category> categories = categoryService.getAllCategories();
	        List<Subcategory> subcategories = subcategoryService.getAllSubcategories();
	        
	        Map<String, Object> responseData = new HashMap<>();
	        responseData.put("categories", categories);
	        responseData.put("subcategories", subcategories);

	        return new ResponseEntity<>(responseData, HttpStatus.OK);
	    }

	 @PostMapping("/products/add")
	    public ResponseEntity<String> addProduct(@RequestBody Products product) {
	        productService.addProduct(product);
	        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
	    }

	 @GetMapping("/products/edit/{id}")
	    public ResponseEntity<Map<String, Object>> showEditProductForm(@PathVariable("id") Integer id) {
	        Products product = productService.getProductById(id);
	        if (product == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        List<Category> categories = categoryService.getAllCategories();
	        List<Subcategory> subcategories = subcategoryService.getAllSubcategories();

	        Map<String, Object> responseData = new HashMap<>();
	        responseData.put("product", product);
	        responseData.put("categories", categories);
	        responseData.put("subcategories", subcategories);

	        return new ResponseEntity<>(responseData, HttpStatus.OK);
	    }

	    @PostMapping("/products/edit/{id}")
	    public ResponseEntity<String> editProduct(@PathVariable("id") Integer id, @RequestBody Products product) {
	        Products existingProduct = productService.getProductById(id);
	        if (existingProduct == null) {
	            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	        }

	        // Update the existing product with the new data
	        existingProduct.setName(product.getName());
	        existingProduct.setCategoryId(product.getCategoryId());
	        existingProduct.setSubcategoryId(product.getSubcategoryId());
	        existingProduct.setDescription(product.getDescription());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setQuantity(product.getQuantity());

	        productService.editProduct(existingProduct);

	        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
	    }
	 
//	    @GetMapping("/products/delete/{id}")
//	    public String deleteProduct(@PathVariable("id") Integer id) {
//	        productService.deleteProduct(id);
//	        return "redirect:/products";
//	    }
	    @DeleteMapping("/products/delete/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
	        Products product = productService.getProductById(id);
	        if (product == null) {
	            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	        }

	        productService.deleteProduct(id);

	        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
	    }
	  
}
