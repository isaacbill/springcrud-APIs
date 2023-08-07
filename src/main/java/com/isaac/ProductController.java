package com.isaac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

//	 @GetMapping("/products/edit/{id}")
//	    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
//	        Products product = productService.getProductById(id);
//	        List<Category> categories = categoryService.getAllCategories();
//	        List<Subcategory> subcategories = subcategoryService.getAllSubcategories();
//	        model.addAttribute("categories", categories);
//	        model.addAttribute("subcategories", subcategories);
//	        model.addAttribute("product", product);
//	        return "edit-product";
//	    } 
//
//	    @PostMapping("/products/edit/{id}")
//	    public String editProduct(@PathVariable("id") Integer id, @ModelAttribute("product") Products product) {
//	        product.setId(id);
//	        productService.editProduct(product);
//	        return "redirect:/products";
//	    }
	 @GetMapping("/products/edit/{id}")
	    public Products showEditProductForm(@PathVariable("id") Integer id) {
	        Products product = productService.getProductById(id);
	        return product;
	    }
	 

	    @GetMapping("/products/delete/{id}")
	    public String deleteProduct(@PathVariable("id") Integer id) {
	        productService.deleteProduct(id);
	        return "redirect:/products";
	    }

	  
}
