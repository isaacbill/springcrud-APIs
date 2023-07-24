package com.isaac;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	  
	  @ResponseBody 
	  public String test() { 
		  return "test";
	  
	  }

	 @GetMapping("/products")
	 public String getallProducts(Model model) {
	        List<Products> products = productService.getAllProducts();
	        model.addAttribute("products", products);
	        return "products";
	    }
	 @GetMapping("/products/add")
	    public String showAddProductForm(Model model) {
	        List<Category> categories = categoryService.getAllCategories();
	        List<Subcategory> subcategories = subcategoryService.getAllSubcategories();
	        model.addAttribute("categories", categories);
	        model.addAttribute("subcategories", subcategories);
	        model.addAttribute("product", new Products());
	        return "add-product";
	    }

	 @PostMapping("/products/add")
	    public String addProduct(@ModelAttribute("product") Products products) {
	        productService.addProduct(products);
	        return "redirect:/products";
	    }

	 @GetMapping("/products/edit/{id}")
	    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
	        Products product = productService.getProductById(id);
	        List<Category> categories = categoryService.getAllCategories();
	        List<Subcategory> subcategories = subcategoryService.getAllSubcategories();
	        model.addAttribute("categories", categories);
	        model.addAttribute("subcategories", subcategories);
	        model.addAttribute("product", product);
	        return "edit-product";
	    } 

	    @PostMapping("/products/edit/{id}")
	    public String editProduct(@PathVariable("id") Integer id, @ModelAttribute("product") Products product) {
	        product.setId(id);
	        productService.editProduct(product);
	        return "redirect:/products";
	    }
	
//	 @GetMapping("/products/edit/{id}")
//	    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
//	     Products product = productService.getProductById(id);
//	      model.addAttribute("product", product);
//	      return "edit-product";
//	 }
//	 @PostMapping("/products/edit/{id}")
//	 public String editProduct(@ModelAttribute("product") Products product) {
//	     productService.editProduct(product);
//	     return "redirect:/products";
//	 }

	    @GetMapping("/products/delete/{id}")
	    public String deleteProduct(@PathVariable("id") Integer id) {
	        productService.deleteProduct(id);
	        return "redirect:/products";
	    }

	  
}
